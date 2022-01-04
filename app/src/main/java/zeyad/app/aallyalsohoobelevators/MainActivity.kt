package zeyad.app.aallyalsohoobelevators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import zeyad.app.aallyalsohoobelevators.pager.SwapAdapter
import zeyad.app.aallyalsohoobelevators.request.RequestFragment
import zeyad.app.aallyalsohoobelevators.services.ServicesFragment
import zeyad.app.aallyalsohoobelevators.services.data.DataFirebaseServicesContracts
import zeyad.app.aallyalsohoobelevators.start.StartFragment
import zeyad.app.aallyalsohoobelevators.types.TypesOfElevatorsFragment
import zeyad.app.aallyalsohoobelevators.welcome.welcomeFragment

class MainActivity : AppCompatActivity() {
    //============ create variable inhered from ViewPager2=====================//
    lateinit var viewPager: ViewPager2

    //=========================================================================//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.e("TAG", "getContract")
      //  Log.e("TAG", " ${FirebaseFirestore.getInstance().collection("Contracts").document("Contracts")}")

//        val contract = hashMapOf(
//            "Contract" to "Monthly",
//            "Contract2" to "Six Months",
//            "Contract3" to "Yearly"
//        )
//        val db = Firebase.firestore
//
//       /* db.collection("Contracts").add(contract).addOnSuccessListener{
//        Log.d("TAG", "onSuccess")
//        }.addOnFailureListener {   Log.d("TAG", "onFaild ") }
//        */


      //  getContract1()
        //======================= To Hide Action Bar=================================//
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        //=========================================================================//

        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.welcomeFragment) as NavHostFragment
        val navController = navHostFragment.navController

        //=======================For view Pager2 =====================
        viewPager = findViewById(R.id.view_swap)
        val fragments: ArrayList<Fragment> = arrayListOf(
            welcomeFragment(),
            StartFragment(),
            ServicesFragment(),
            RequestFragment(),
            TypesOfElevatorsFragment()
        )
        val adapter = SwapAdapter(fragments, this)
        viewPager.adapter = adapter
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }




//    fun getContract1() {
//
//        val db = Firebase.firestore
//        db.collection("Contracts")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    Toast.makeText(this, "${document.id} => ${document}", Toast.LENGTH_SHORT).show()
//
//                  //  Log.e("TAG", "getContract1: ${document.toObject(DataFirebaseServicesContracts::class.java)}", )
//                    for (name in document.data) {
//                        Toast.makeText(this, "$name", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.w("TAG", "Error getting documents.", exception)
//            }
//    }


    fun getContract() {
        val db = Firebase.firestore


      /*  db.addOnSuccessListener { documents ->
                for (document in documents) {
                    var contracts =
                        document.toObject(DataFirebaseServicesContracts::class.java)

                }
            }
                .addOnFailureListener {
    //            Toast.makeText(requireContext(), "an error is found", Toast.LENGTH_SHORT).show()

                }*/
    }
}