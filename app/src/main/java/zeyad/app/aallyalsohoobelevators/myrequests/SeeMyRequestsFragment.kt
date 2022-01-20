package zeyad.app.aallyalsohoobelevators.myrequests

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentSeeMyRequestsBinding



class SeeMyRequestsFragment : Fragment() {
    lateinit var binding: FragmentSeeMyRequestsBinding
    //================user id =============================//
    val userId = FirebaseAuth.getInstance().currentUser?.uid
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getReadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSeeMyRequestsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//========================to back to satrt fragment from see my request fragment=================//
        binding.backto.setOnClickListener {
            findNavController().navigate(R.id.action_seeMyRequestsFragment_to_startFragment)
        }
        getReadData()


    }

    //=======================this for read last data for user======================//
    var list = MutableLiveData<MutableList<MyRequests>>(mutableListOf())
    fun getReadData() {

    FirebaseFirestore.getInstance().collection("Requests").document(userId!!)
        .get()
        .addOnSuccessListener { documentSnapshot ->
            val getting = documentSnapshot.toObject(MyRequests::class.java)
//            var get = MyRequests("Country","Floor","Machine","Types","Image Cabin")

            list.value?.add(getting!!)
            Log.d("TAG", "getReadData: ${list.value} ")
             binding.recycleMyRequest.adapter = MyRequestsAdapter(requireContext(),list.value!!)

        }
        .addOnFailureListener {
            Toast.makeText(requireContext(),"error is founding",Toast.LENGTH_SHORT)
                .show()
        }
}
}



