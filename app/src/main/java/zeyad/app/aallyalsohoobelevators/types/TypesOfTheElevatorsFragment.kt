package zeyad.app.aallyalsohoobelevators.types

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentTypesOfTheElevatorsBinding


class TypesOfTheElevatorsFragment : Fragment() {
  lateinit var binding: FragmentTypesOfTheElevatorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding = FragmentTypesOfTheElevatorsBinding.inflate(layoutInflater)
        binding.recycleTypes.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //==========================back to start fragment=================================//
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_typesOfTheElevatorsFragment_to_startFragment)
        }

        //===============call function onViewCreated ============================//
     getTypesOfElevators()
    }

    //============================function to get Types Of Elevators from FireStore====================//
    fun getTypesOfElevators(){

        FirebaseFirestore.getInstance().collection("Tyoes OF Elevators")
            .get()
            .addOnSuccessListener { docuemonts ->
                for (docuemont in docuemonts){
                    val getting = docuemonts.toObjects(TypesOfTheElevatorsModel::class.java)
                    binding.recycleTypes.adapter = TypeOfTheElevatorsAdapter(requireContext(),getting)
            }

            }
            .addOnFailureListener {
   Toast.makeText(requireContext(),"error is founding",Toast.LENGTH_SHORT)
       .show()
            }
    }




}
