package zeyad.app.aallyalsohoobelevators.services


import android.R
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import zeyad.app.aallyalsohoobelevators.services.data.DataFirebaseServicesContracts
import java.lang.Exception


class ServicesViewModel : ViewModel() {
//val _contractslist = MutableLiveData<String?>()
//    var contractslist: LiveData<String?> = _contractslist
//
//
//
//    fun getContract1() {
//        val db = Firebase.firestore
//        val list: MutableCollection<DataFirebaseServicesContracts>
//        db.collection("Contracts").document("Contracts")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result.data!!.values) {
//                    Log.e("TAG", "real:${result.data!!.values}")
//                    var m =   (result!!.data!!.values.toTypedArray())
//
//
//                }
//
//            }
//            .addOnFailureListener { exception ->
//                Log.w("TAG", "Error getting documents.", exception)
//            }
//    }
}