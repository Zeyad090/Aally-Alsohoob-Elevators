package zeyad.app.aallyalsohoobelevators.users

import android.app.Activity
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.jetbrains.annotations.NotNull
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    private val emailLiveData = MutableLiveData<String>()
    private val passwordLiveData = MutableLiveData<String>()

    //===================MediatorLiveData is combain tow or more LiveData together=================//
    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        addSource(emailLiveData) { email ->
            val password = passwordLiveData.value
            //=====this is for isValidLiveData=====//
            this.value = validateform(email, password)

        }
        addSource(passwordLiveData) { password ->
            val email = emailLiveData.value
            this.value = validateform(email, password)

        }
    }


    lateinit var binding: FragmentSignInBinding
    val userID = FirebaseAuth.getInstance().currentUser?.uid
//=============for launch  sign in ==============================//
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
        if (res?.idpResponse != null) {
            userID
            findNavController().navigate(R.id.action_signInFragment_to_startFragment,)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    // ===========build email - phone number - Google sign in================
    val providers = arrayListOf(
        AuthUI.IdpConfig.GoogleBuilder().build())

    // ============Create and launch sign-in intent/////////////////
    val signInIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .build()
    //=======================providers for phoone number=====================================//
//=======================sign in for phone number============================================//
    val providersPhone = arrayListOf(
        AuthUI.IdpConfig.PhoneBuilder().build())
    val singInPhone = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providersPhone)
        .build()


    //===================== sign in Result function=========================================//
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == Activity.RESULT_OK) {

            Log.i(ContentValues.TAG,
                "Successfully singed ${FirebaseAuth.getInstance().currentUser}")

        } else {
            Log.i(ContentValues.TAG, "Sign in unsuccessful ${response?.error?.errorCode}")

        }

    }
    //========================= sign out function===============================//

//==============================================================================//


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //===================go to register fragment==========================//
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_registerFragment)
        }
//================== start sign in for Google===================================//
        binding.signInButton.setOnClickListener {
            signInLauncher.launch(signInIntent)
            //var a= FirebaseAuth.getInstance().currentUser.
//====================== start sign in for phone number==========================//
        }
        binding.phoneSignIn.setOnClickListener {
            signInLauncher.launch(singInPhone)

//=======================back to welcome fragment================================//
        }
        binding.backToo.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_welcomeFragment)
        }
//=====================for chek input is matches conditions in the function validateForm==============//
        binding.emailInputLayout2.editText?.doOnTextChanged { text, _, _, _ ->
            emailLiveData.value = text?.toString()
        }

        binding.passwordInputLayout3.editText?.doOnTextChanged { text, _, _, _ ->
            passwordLiveData.value = text?.toString()
        }
        isValidLiveData.observe(viewLifecycleOwner) { isValid ->
            binding.emailSignIn.isEnabled = isValid

        }
    }


    //======================for email and password is  valid or not =============================//
    private fun validateform(email: String?, password: String?): Boolean {
        val isValidEmail = email != null && email.isNotBlank() && email.contains("@")

        val isValidPassword = password != null && password.isNotBlank() && password.length >= 8

        return isValidEmail && isValidPassword
    }
}


