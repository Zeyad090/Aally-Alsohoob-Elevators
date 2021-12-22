package zeyad.app.aallyalsohoobelevators.services

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zeyad.app.aallyalsohoobelevators.databinding.FragmentServicesBinding


class ServicesFragment : Fragment() {
    lateinit var binding: FragmentServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate: start", )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServicesBinding.inflate(inflater,container,false)
        return binding.root
    }

}
