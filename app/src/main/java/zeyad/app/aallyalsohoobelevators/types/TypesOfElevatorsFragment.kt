package zeyad.app.aallyalsohoobelevators.types

import android.net.Uri
import android.net.UrlQuerySanitizer
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentTypesOfElevatorsBinding


class TypesOfElevatorsFragment : Fragment() {

lateinit var binding: FragmentTypesOfElevatorsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val elevetor1  = "https://files.fm/thumb_show.php?i=g448agax5"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     return inflater.inflate(R.layout.fragment_types_of_elevators, container, false)
    }


}