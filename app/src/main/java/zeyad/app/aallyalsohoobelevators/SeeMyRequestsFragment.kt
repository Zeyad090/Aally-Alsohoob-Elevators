package zeyad.app.aallyalsohoobelevators

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.databinding.FragmentSeeMyRequestsBinding


class SeeMyRequestsFragment : Fragment() {
    lateinit var binding: FragmentSeeMyRequestsBinding
    val userId = FirebaseAuth.getInstance().currentUser?.uid
    lateinit var imgeUrlcabin: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        binding.backto.setOnClickListener {
            findNavController().navigate(R.id.action_seeMyRequestsFragment_to_startFragment)
        }

        binding.buttonReadData.setOnClickListener {
            readMyData()
        }
    }

    //=======================this for read last data for user======================//
    fun readMyData() {
        val db = FirebaseFirestore.getInstance()
        val dar = FirebaseFirestore.getInstance()
        dar.collection("Cabin photos")
        db.collection("Requests").document(userId!!)
            .get()
            .addOnSuccessListener { result ->
                try {
                    for (document in result.data!!.values) {
                        binding.readData.setText(result!!.data!!.values.toString())

                    }
                } catch (e: Exception) {
                }

            }

                .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting data.", exception)
            }
    }
}



