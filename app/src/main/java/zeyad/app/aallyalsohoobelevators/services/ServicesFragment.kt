package zeyad.app.aallyalsohoobelevators.services


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentServicesBinding
import zeyad.app.aallyalsohoobelevators.services.data.DataFirebaseServicesContracts
import kotlin.math.log
import kotlin.reflect.typeOf


class ServicesFragment : Fragment() {
    private val viewModel: ServicesViewModel by viewModels()
    lateinit var binding: FragmentServicesBinding
    // lateinit var  spinner :Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServicesBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


          getContract1()




        binding.onTime.setOnClickListener {
            Toast.makeText(requireContext(), "your request sent successfully", Toast.LENGTH_SHORT)
                .show()
        }

    }



    fun getContract1() {
        val db = Firebase.firestore
        val list: MutableCollection<DataFirebaseServicesContracts>
        db.collection("Contracts").document("Contracts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result.data!!.values) {

                    Log.e("TAG", "real:${result.data!!.values}")
                    binding.fixSpinner.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item
                        ,result!!.data?.values!!.toTypedArray() )
                }


            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }




}


