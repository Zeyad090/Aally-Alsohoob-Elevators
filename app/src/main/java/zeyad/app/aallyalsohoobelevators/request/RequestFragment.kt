package zeyad.app.aallyalsohoobelevators.request

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import zeyad.app.aallyalsohoobelevators.databinding.FragmentRequestBinding


class RequestFragment : Fragment() {
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



 }
