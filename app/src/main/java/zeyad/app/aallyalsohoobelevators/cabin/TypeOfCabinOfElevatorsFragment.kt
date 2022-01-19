package zeyad.app.aallyalsohoobelevators.cabin

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentTypeOfCabinOfElevatorsBinding

enum class Cabin { LOADING, ERROR, DONE }
class TypeOfCabinOfElevatorsFragment : Fragment() {
    private val viewModel: CabinViewModel by viewModels()
    lateinit var binding: FragmentTypeOfCabinOfElevatorsBinding


    val imageType = view?.findViewById<ImageView>(R.id.type_of_elevator)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        // Inflate the layout for this fragment
        binding = FragmentTypeOfCabinOfElevatorsBinding.inflate(layoutInflater)
        binding.recyclePhoto.apply {
            layoutManager = LinearLayoutManager(requireContext())

        }

        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)



        binding.backTo.setOnClickListener {
            findNavController().navigate(R.id.action_typesOfCabinOfElevatorsFragment_to_startFragment)
        }
        getCabinOfElevators()
    }

    var list: MutableList<CabinOfTypeOfElevatorsModel> = mutableListOf()

    private fun getCabinOfElevators() {
        var counter = 0
        FirebaseFirestore.getInstance().collection("Cabin photos").document("Cabin")
            .get()
            .addOnSuccessListener { documents ->
                for (dcouments in documents.data?.values!!) {
                    var cabin = documents.data?.values?.toMutableList()
                    list.add(CabinOfTypeOfElevatorsModel(cabin?.get(counter++).toString()))
                }
                binding.recyclePhoto.adapter =
                    TypeOfCabinOfElevatorsAdapter(requireContext(), list) {

                        findNavController().navigate(R.id.action_typesOfCabinOfElevatorsFragment_to_requestFragment,
                            Bundle().apply {
                                putString("image", it.photo)
                            })
                    }
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "error is found", Toast.LENGTH_SHORT)
                    .show()
            }

    }
//    fun bindstatus(statusImageView: ImageView,
//    status:Cabin){
//        binding.statusImage.setImageResource(R.drawable.loading_img)
//
//        when(status){
//            Cabin.LOADING -> {
//                statusImageView.visibility = View.VISIBLE
//                statusImageView.setImageResource(R.drawable.loading_img)
//            }
//
//        Cabin.ERROR -> {
//            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.ic_connection_error)
//        }
//        Cabin.DONE -> {
//            statusImageView.visibility = View.GONE
//        }
//    }
//   }
}