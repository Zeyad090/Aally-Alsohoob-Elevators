package zeyad.app.aallyalsohoobelevators.start

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root

    }


    //==========================================================================================//
    /**
     * use navigation from Start fragment to other fragments
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //================to go to see my requests fragment from start fragment===================//
        binding.readMyData.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_seeMyRequestsFragment)
        }
//===========================go to services fragment from start fragment ==========================//
        binding.servies.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_servicesFragment)
        }
        //========================go to request fragment from start fragment=======================//
        binding.request.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_requestFragment)
        }
        //======================go to types Of Cabin Of elevators fragment from start fragment=====//
        binding.cabinTypes.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_typesOfCabinOfElevatorsFragment)
        }
        //=============go to types Of the elevators fragment from start fragment
        binding.elevatorsTypes.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_typesOfTheElevatorsFragment)
        }
        //====================for sign out from email and phone number==============================//
        binding.signOut.setOnClickListener {
            signOut()

        }

    }
//==============================================================================================//
//=================================function for sign out========================================//
    fun signOut() {
        AuthUI.getInstance()
            .signOut(requireContext())
            .addOnCompleteListener {
                Firebase.auth.signOut()
                findNavController().navigate(R.id.action_startFragment_to_signInFragment)
            }

    }
}