package zeyad.app.aallyalsohoobelevators.request

import android.app.Activity
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.rpc.Help
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentRequestBinding
import zeyad.app.aallyalsohoobelevators.services.ServicesViewModel


class RequestFragment : Fragment() {
    private  val viewModel: RequestViewModel by viewModels()
   lateinit var binding: FragmentRequestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentRequestBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding..setOnClickListener {
//            Toast.makeText(requireContext(),"your request sent successfully",Toast.LENGTH_SHORT).show()
//        }
    }


 }
