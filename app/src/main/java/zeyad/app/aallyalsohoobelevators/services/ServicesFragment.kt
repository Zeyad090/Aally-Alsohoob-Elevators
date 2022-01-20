package zeyad.app.aallyalsohoobelevators.services


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentServicesBinding
import zeyad.app.aallyalsohoobelevators.services.data.DataFirebaseServicesContracts
import kotlin.math.log
import kotlin.reflect.typeOf


    class ServicesFragment : Fragment() {

    val userId = FirebaseAuth.getInstance().currentUser?.uid

    private val viewModel: ServicesViewModel by viewModels()
    lateinit var binding: FragmentServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //====================here we call the function===============================//
        getContract1()

        //============================================================================//

        binding.serviceConfirmation.setOnClickListener {
            Toast.makeText(requireContext(), "your request sent successfully", Toast.LENGTH_SHORT)
                .show()
            val chosenTime = binding.services.text.toString()
            setContract1(chosenTime)
        }
        binding.backTo.setOnClickListener {
            findNavController().navigate(R.id.action_servicesFragment_to_startFragment)
        }

    }

    //==========================================get services form fire store======================================//
    fun getContract1() {
        val db = Firebase.firestore
        db.collection("Contracts").document("Contracts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result.data!!.values) {

                    Log.e("TAG", "real:${result.data!!.values}")
                    val servicesMenu = ArrayAdapter(requireContext(),
                        R.layout.dropdown_items,
                        result!!.data!!.values.toTypedArray())
                    binding.services.setAdapter(servicesMenu)

                }

            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }

    //==========================================set services form fire store======================================//
    fun setContract1(chosenContract: String) {
        val db = Firebase.firestore
        db.collection("Contracts").document(userId!!)
            .set(mapOf("Contract" to chosenContract))
            .addOnSuccessListener {

            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }


}


