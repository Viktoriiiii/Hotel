package ru.spb.viktorii.hotel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import ru.spb.viktorii.hotel.MAIN
import ru.spb.viktorii.hotel.R
import ru.spb.viktorii.hotel.adapters.PagerAdapterForImages
import ru.spb.viktorii.hotel.databinding.FragmentHotelBinding


class HotelFragment : Fragment() {

    private var _binding: FragmentHotelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mbChooseRoom.setOnClickListener {
            MAIN.navController.navigate(R.id.action_hotelFragment_to_choiceOfHotelRoomFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        MAIN.setItemsInToolbar(getString(R.string.hotel), false)

        val resources = intArrayOf(
            R.drawable.club_prive_by_belek_club_house,
            R.drawable.img_hotel,
            R.drawable.img_hotel,
            R.drawable.img_hotel,
            R.drawable.img_hotel
        )

        val mCustomPagerAdapter = PagerAdapterForImages(MAIN, resources)
        binding.cvPhoto.viewPager.adapter = mCustomPagerAdapter
        TabLayoutMediator(binding.cvPhoto.tabDots, binding.cvPhoto.viewPager) { _, _ -> }.attach()
        binding.cvPhoto.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}