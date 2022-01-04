package zeyad.app.aallyalsohoobelevators.pager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import zeyad.app.aallyalsohoobelevators.welcome.welcomeFragment


class SwapAdapter(val items: ArrayList<Fragment>, activity :AppCompatActivity)
    : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
return items.size
    }

    override fun createFragment(position: Int): Fragment {
return items[position]
    }

}

