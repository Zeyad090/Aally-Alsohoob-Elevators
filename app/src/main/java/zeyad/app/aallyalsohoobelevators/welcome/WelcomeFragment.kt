package zeyad.app.aallyalsohoobelevators.welcome

import android.app.Activity.RESULT_OK
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log

import android.view.*
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.DialogSitting
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentWelcomeBinding
import zeyad.app.aallyalsohoobelevators.users.UserProfileFragmentDirections
//import zeyad.app.aallyalsohoobelevators.pager.SwapAdapter
import java.lang.Thread.sleep


class WelcomeFragment : Fragment() {

    lateinit var binding: FragmentWelcomeBinding

    val theme = view?.findViewById<Switch>(R.id.theme)

    val language = view?.findViewById<Switch>(R.id.language)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        theme?.setOnCheckedChangeListener {  buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.sitting.setOnClickListener {
            showSitting()
        }

//===================go from welcome fragment to sign in fragment==================//
        binding.start.setOnClickListener {

            findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment)
        }
//===================================================================//

    }

    fun showSitting() {


        DialogSitting().show(parentFragmentManager, "Setting")

    }
}