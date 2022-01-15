package zeyad.app.aallyalsohoobelevators.welcome

import android.app.Activity.RESULT_OK
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log

import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentWelcomeBinding
import zeyad.app.aallyalsohoobelevators.users.UserProfileFragmentDirections
//import zeyad.app.aallyalsohoobelevators.pager.SwapAdapter
import java.lang.Thread.sleep


class WelcomeFragment : Fragment() {

  lateinit var binding: FragmentWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

  binding.start.setOnClickListener {

      findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment)
  }
//===================================================================//

    }}