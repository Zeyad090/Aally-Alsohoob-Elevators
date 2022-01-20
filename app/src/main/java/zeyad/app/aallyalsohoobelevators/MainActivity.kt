package zeyad.app.aallyalsohoobelevators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {


    //=========================================================================//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //======================= To Hide Action Bar=================================//
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        //=========================================================================//

        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.welcomeFragment) as NavHostFragment
        val navController = navHostFragment.navController




}}