package zeyad.app.aallyalsohoobelevators.request

import android.app.Activity
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout
import com.google.rpc.Help
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.cabin.CabinViewModel
import zeyad.app.aallyalsohoobelevators.cabin.TypeOfCabinOfElevatorsFragment
import zeyad.app.aallyalsohoobelevators.databinding.FragmentRequestBinding
import zeyad.app.aallyalsohoobelevators.services.ServicesViewModel


class RequestFragment : Fragment() {
    private val typesLiveData = MutableLiveData<String>()
    private val floorLiveData = MutableLiveData<String>()
    private val machineLiveData = MutableLiveData<String>()
    private val countryLiveData =  MutableLiveData<String>()

    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        addSource(typesLiveData) { types ->
            val floor = floorLiveData.value
            val machine = machineLiveData.value
            val country = countryLiveData.value

            this.value = vaiddatain(types,floor,machine,country)
        }
        addSource(floorLiveData) { floor ->
            val types = typesLiveData.value
            val machine = machineLiveData.value
            val country = countryLiveData.value


            this.value = vaiddatain(types,floor,machine,country)
        }
        addSource(machineLiveData) { machine ->
            val floor = floorLiveData.value
            val types = typesLiveData.value
            val country = countryLiveData.value


            this.value = vaiddatain(types,floor,machine,country)
        }

        addSource(countryLiveData) { country ->
            val floor = floorLiveData.value
            val types = typesLiveData.value
            val machine = machineLiveData.value


            this.value = vaiddatain(types,floor,machine,country)
        }


    }



    private val viewModel: RequestViewModel by viewModels()
    lateinit var binding: FragmentRequestBinding
    lateinit var imageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUrl = it.getString("image", "")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = FragmentRequestBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.menu4.editText?.doOnTextChanged { text, _, _, _ ->
            typesLiveData.value = text?.toString()
        }
        binding.menu3.editText?.doOnTextChanged { text, _, _, _ ->
            countryLiveData.value = text?.toString()
        }
        binding.menu2.editText?.doOnTextChanged { text, _, _, _ ->
            machineLiveData.value = text?.toString()
        }
        binding.menu.editText?.doOnTextChanged { text, _, _, _ ->
            floorLiveData.value = text?.toString()
        }

        isValidLiveData.observe(viewLifecycleOwner){ isValid ->
            binding.requestButton.isEnabled = isValid

        }

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_requestFragment_to_startFragment)
        }

        binding.selectCabin.setOnClickListener {
            findNavController().navigate(R.id.action_requestFragment_to_typesOfCabinOfElevatorsFragment)
        }


        binding.requestButton.setOnClickListener {
            findNavController().navigate(R.id.action_requestFragment_to_myRequestsFragment,
                Bundle().apply {
                    putString("types", binding.TypesOfElevatorsMenu.text.toString())
                    putString("floor", binding.floor.text.toString())
                    putString("machine", binding.machineWight.text.toString())
                    putString("country", binding.countryMade.text.toString())
                    putString("image", imageUrl.toString())
                })


        }
        Glide.with(this.requireContext())
            .load(imageUrl)
            .into(binding.requestPhotoOfCabin)
        //==============================dropdown menu array for floors=========================//
        val floors = resources.getStringArray(R.array.Floor)
        val arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, floors)
        binding.floor.setAdapter(arrayAdapter)
//===============================================================================================//


        //=============================dropdown menu for machine wight==========================//
        val machineWight = resources.getStringArray(R.array.machine_wight)
        val arrayAdapterMachine = ArrayAdapter(requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            machineWight)
        binding.machineWight.setAdapter(arrayAdapterMachine)

        //======================================================================================//

        val countryMade = resources.getStringArray(R.array.Country_Made)
        val arrayAdapterCountry =
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, countryMade)
        binding.countryMade.setAdapter(arrayAdapterCountry)


        val typesOfTheElevators = resources.getStringArray(R.array.Types_of_Elevator)
        val arrayAdapterTypes = ArrayAdapter(requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            typesOfTheElevators)
        binding.TypesOfElevatorsMenu.setAdapter(arrayAdapterTypes)
    }


    private fun vaiddatain(types:String?,floor:String?,machine:String?,country:String?): Boolean {
        val isValidTypes = types != null && types.isNotEmpty()
        val isValidFloor = floor != null && floor.isNotEmpty()
        val isValidMachine = machine != null && machine.isNotEmpty()
        val isValidCountry = country != null && country.isNotEmpty()

        return isValidCountry && isValidFloor && isValidTypes && isValidMachine
    }
}
