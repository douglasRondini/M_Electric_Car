package adapter

import android.icu.text.Transliterator.Position
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.my_electric_car.CarsFragment
import com.example.my_electric_car.FavoritesFragment

class TabsAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CarsFragment()
            1 -> FavoritesFragment()

            else -> CarsFragment()

        }
    }

}