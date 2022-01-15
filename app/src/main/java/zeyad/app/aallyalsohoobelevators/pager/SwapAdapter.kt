package zeyad.app.aallyalsohoobelevators.pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import android.app.Activity
import zeyad.app.aallyalsohoobelevators.MainActivity


class SwapAdapter(val items: ArrayList<Fragment>,Activity: MainActivity)
    : FragmentStateAdapter(Activity) {
    override fun getItemCount(): Int {
return items.size
    }

    override fun createFragment(position: Int): Fragment {
return items[position]
    }

}

