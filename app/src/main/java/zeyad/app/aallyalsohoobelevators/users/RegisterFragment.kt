package zeyad.app.aallyalsohoobelevators.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
  lateinit var binding : FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
binding = FragmentRegisterBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backTo.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_signInFragment)
        }
    }

}