package zeyad.app.aallyalsohoobelevators.welcome


import android.app.Activity.RESULT_OK
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log

import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentWelcomeBinding
//import zeyad.app.aallyalsohoobelevators.pager.SwapAdapter
import zeyad.app.aallyalsohoobelevators.request.RequestFragment
import zeyad.app.aallyalsohoobelevators.services.ServicesFragment
import zeyad.app.aallyalsohoobelevators.start.StartFragment
import zeyad.app.aallyalsohoobelevators.types.TypesOfElevatorsFragment
import java.lang.Thread.sleep


class welcomeFragment : Fragment() {

  lateinit var binding: FragmentWelcomeBinding

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    // ===========build email - phone number - Google sign in================
    val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
       AuthUI.IdpConfig.PhoneBuilder().build(),
       AuthUI.IdpConfig.GoogleBuilder().build())
    // Create and launch sign-in intent
    val signInIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .build()


//===================== sign in function=========================================//
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            Log.i(TAG,"Successfully singed ${FirebaseAuth.getInstance().currentUser}")

            binding.signIn.text ="sign out"

        } else {
              Log.i(TAG,"Sign in unsuccessful ${response?.error?.errorCode}")
            binding.signIn.text= "sign in"
        }

    }
    //========================= sign out function===============================//
    private fun signOut(){
       AuthUI.getInstance()
          .signOut(requireContext())
            .addOnCompleteListener {

           binding.signIn.text ="sign in"
                Firebase.auth.signOut()
          }
    }
//==============================================================================//


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // =====================For lunch Sign in=========================//
    binding.signIn.setOnClickListener {
        sleep(1000)
        signInLauncher.launch(signInIntent)
    }
//===================================================================//

    binding.go.setOnClickListener {

          findNavController().navigate(R.id.action_welcomeFragment_to_startFragment) }
    }

}
