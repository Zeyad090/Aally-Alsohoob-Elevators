package zeyad.app.aallyalsohoobelevators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import zeyad.app.aallyalsohoobelevators.pager.SwapAdapter
import zeyad.app.aallyalsohoobelevators.request.RequestFragment
import zeyad.app.aallyalsohoobelevators.services.ServicesFragment
import zeyad.app.aallyalsohoobelevators.start.StartFragment
import zeyad.app.aallyalsohoobelevators.cabin.TypeOfCabinOfElevatorsFragment
import zeyad.app.aallyalsohoobelevators.welcome.welcomeFragment

class MainActivity : AppCompatActivity() {
    //============ create variable inhered from ViewPager2=====================//
    lateinit var viewPager: ViewPager2

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

        //=======================For view Pager2 =====================
        viewPager = findViewById(R.id.view_swap)
        val fragments: ArrayList<Fragment> = arrayListOf(
            welcomeFragment(),
            StartFragment(),
            ServicesFragment(),
            RequestFragment(),
            TypeOfCabinOfElevatorsFragment()
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




}