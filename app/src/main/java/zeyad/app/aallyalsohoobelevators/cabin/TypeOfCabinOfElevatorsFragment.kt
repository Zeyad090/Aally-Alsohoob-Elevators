package zeyad.app.aallyalsohoobelevators.cabin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import zeyad.app.aallyalsohoobelevators.databinding.ActivityMainBinding.inflate
import zeyad.app.aallyalsohoobelevators.databinding.FragmentTypeOfElevatorsBinding


class TypeOfCabinOfElevatorsFragment : Fragment() {

    lateinit var binding: FragmentTypeOfElevatorsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTypeOfElevatorsBinding.inflate(layoutInflater)
        binding.recyclePhoto.apply {
            layoutManager = LinearLayoutManager(requireContext())
            binding.recyclePhoto.setItemViewCacheSize(20)
            binding.recyclePhoto.setHasFixedSize(true)
        }

        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getTypesOfElevators()

    }

    var list :MutableList<CabinOfTypeOfElevatorsModel> = mutableListOf()


    private fun getTypesOfElevators() {
        var counter = 0
        FirebaseFirestore.getInstance().collection("Cabin photos").document("Cabin")
            .get()
            .addOnSuccessListener { documents ->
                for (dcouments in documents.data?.values!!) {
                    var a = documents.data?.values?.toMutableList()
                   list.add(CabinOfTypeOfElevatorsModel(a?.get(counter++).toString()))

                }
                binding.recyclePhoto.adapter = TypeOfCabinOfElevatorsAdapter(requireContext(),list)
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "error is found", Toast.LENGTH_SHORT)
                    .show()
            }

    }
}