package zeyad.app.aallyalsohoobelevators.myrequests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentMyRequestsBinding


class MyRequestsFragment : Fragment() {
//=========================user id ==========================//
    val userId = FirebaseAuth.getInstance().currentUser?.uid
//==============for arguments image to my request fragment ===================//
    lateinit var imgeUrl: String
    lateinit var binding: FragmentMyRequestsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //============receive arguments from type of cabin of elevators==================//

        arguments.let {

            imgeUrl = it!!.getString("image", "")


        }
        // Inflate the layout for this fragment
        binding = FragmentMyRequestsBinding.inflate(inflater, container, false)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//==========================back to request fragment=====================================//
        binding.backToBack.setOnClickListener {
            findNavController().navigate(R.id.action_myRequestsFragment_to_requestFragment)
        }



        binding.update.setOnClickListener {
            findNavController().navigate(R.id.action_myRequestsFragment_to_requestFragment)
        }

//================handle the image by Glide ===================================//
        Glide.with(this.requireContext())
            .load(imgeUrl)
            .into(binding.imageReseve)
//====================================receive arguments =========================//
        binding.textReseveType.text =
            requireArguments().getString("types", binding.textReseveType.text.toString())
        binding.textReseveFloor.text =
            requireArguments().getString("floor", binding.textReseveFloor.text.toString())
        binding.textReseveMachine.text =
            requireArguments().getString("machine", binding.textReseveMachine.text.toString())
        binding.textReseveMade.text =
            requireArguments().getString("country", binding.textReseveMade.text.toString())
        binding.submit.setOnClickListener {
            val Country = binding.textReseveMade.text.toString()
            val Floor = binding.textReseveFloor.text.toString()
            val Machine = binding.textReseveMachine.text.toString()
            val Types = binding.textReseveType.text.toString()
            val imageCabin = imgeUrl.toString()


//=====================call function  sendData in onViewCreated=======================//
            sendData(Country, Floor, Machine, Types, imageCabin)

        }
        binding.delete.setOnClickListener {
            val Country = binding.textReseveMade.text.toString()
            val Floor = binding.textReseveFloor.text.toString()
            val Machine = binding.textReseveMachine.text.toString()
            val Types = binding.textReseveType.text.toString()
            val imageCabin = imgeUrl.toString()


//===================call function deleteData in onViewCreated=============================//
            deleteData(Country, Floor, Machine, Types, imageCabin)

        }
    }
//=======================function to set data in fire store ===========================//
    fun sendData(
        country: String,
        floor: String,
        machine: String,
        types: String,
        imageCabin: String,
    ) {
        val db = FirebaseFirestore.getInstance()
        val request: MutableMap<String, Any> = HashMap()
        request["Country"] = country
        request["Floor"] = floor
        request["Machine"] = machine
        request["Types"] = types
        request["imageCabin"] = imageCabin

        db.collection("Requests").document(userId!!).set(request, SetOptions.merge())
            .addOnSuccessListener {
                userId
                Toast.makeText(requireContext(),
                    "your request is sent successfully",
                    Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "your request is not sent  ", Toast.LENGTH_SHORT)
                    .show()

            }

    }
//============================delete data from fire store=================================//
    fun deleteData(
        country: String,
        floor: String,
        machine: String,
        types: String,
        imageCabin: String,
    ) {


        val db = FirebaseFirestore.getInstance()
        db.collection("Requests").document(userId!!)
            .delete()
            .addOnSuccessListener {
                Toast.makeText(requireContext(),
                    "your request is sent successfully",
                    Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "your request is not sent  ", Toast.LENGTH_SHORT)
                    .show()

            }



}

}

