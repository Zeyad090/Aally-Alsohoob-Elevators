package zeyad.app.aallyalsohoobelevators.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import zeyad.app.aallyalsohoobelevators.R
import zeyad.app.aallyalsohoobelevators.databinding.FragmentRegisterBinding
import java.lang.Error
import kotlin.time.Duration.Companion.days


class RegisterFragment : Fragment() {
    private val emailRegisterLiveData = MutableLiveData<String>()
    private val passwordRegisterLiveData = MutableLiveData<String>()
    private val phoneNumberLiveData = MutableLiveData<String>()

    //===================MediatorLiveData is combain tow or more LiveData together=================//
    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        addSource(emailRegisterLiveData) { email ->
            val password = passwordRegisterLiveData.value
            val phone = phoneNumberLiveData.value
            this.value = validateRegisterform(email, password, phone)
        }
        addSource(passwordRegisterLiveData) { password ->
            val email = emailRegisterLiveData.value
            val phone = phoneNumberLiveData.value
            this.value = validateRegisterform(email, password, phone)
        }
        addSource(phoneNumberLiveData) { phone ->
            val passwordn = passwordRegisterLiveData.value
            val email = emailRegisterLiveData.value
            this.value = validateRegisterform(email, passwordn, phone)
        }

    }


    lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backTo.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_signInFragment)
        }
//=====================for chek input is matches conditions in the function validateRegisterform==============//

        binding.registerEmailInputLayout2.editText?.doOnTextChanged { text, _, _, _ ->
            emailRegisterLiveData.value = text?.toString()
        }
        binding.registerPasswordInputLayout.editText?.doOnTextChanged { text, _, _, _ ->
            passwordRegisterLiveData.value = text?.toString()
        }

        binding.registerPhoneInputLayout.editText?.doOnTextChanged { text, _, _, _ ->
            phoneNumberLiveData.value = text?.toString()
        }
        isValidLiveData.observe(viewLifecycleOwner) { isValid ->
            binding.emailSignUp.isEnabled = isValid

        }


    }

    //======================for email && password && phone is  valid or not =============================//

    fun validateRegisterform(email: String?, password: String?, phone: String?): Boolean {

        val isValidEmail =
            email != null && email.isNotBlank() && email.contains("@") && email.contains(".")
        val isValidPassword = password != null && password.isNotBlank() && password.length >= 8
        val isValidPhone = phone != null && phone.isNotBlank() && phone.length >= 10

        return isValidEmail && isValidPassword && isValidPhone
    }


}