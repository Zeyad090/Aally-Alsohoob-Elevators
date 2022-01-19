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


    val _contractslist = MutableLiveData<ArrayList<String>>()
    var contractslist: MutableLiveData<ArrayList<String>> = _contractslist

    init {
        getContract1()
    }

    fun getContract1() {
        val db = Firebase.firestore
        val list: MutableCollection<DataFirebaseServicesContracts>
        db.collection("Contracts").document("Contracts")
            .get()
            .addOnSuccessListener { result ->
                // var alldata=mutalis


                for (document in result.data!!.values) {
                    // vaer at= docto.toobject
                    //alldata.add(at)


                }
                //      _contractslist.value = alldata
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }
}