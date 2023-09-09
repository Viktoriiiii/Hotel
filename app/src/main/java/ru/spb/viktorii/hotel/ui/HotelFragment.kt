package ru.spb.viktorii.hotel.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.spb.viktorii.hotel.utils.MAIN
import ru.spb.viktorii.hotel.R
import ru.spb.viktorii.hotel.adapters.PagerAdapterForImages
import ru.spb.viktorii.hotel.databinding.FragmentHotelBinding
import ru.spb.viktorii.hotel.utils.toStringWithRubles
import ru.spb.viktorii.hotel.viewmodels.HotelViewModel
import java.util.*

class HotelFragment : Fragment() {

    private var _binding: FragmentHotelBinding? = null
    private val binding get() = _binding!!

    private val vmHotel: HotelViewModel by inject()

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
        showInfoAboutHotel()
    }

    @SuppressLint("InflateParams")
    fun showInfoAboutHotel() {
        lifecycleScope.launch {
            vmHotel.getHotel()
            vmHotel.hotel.observe(this@HotelFragment){
                binding.tvHotelName.text = it.name
                binding.tvHotelAddress.text = it.address
                binding.tvHotelMinimalPrice.text = it.minimalPrice.toStringWithRubles()
                binding.tvHotelPriceForIt.text = it.priceForIt
                binding.tvGrade.text = String.format("${it.rating} ${it.ratingName}")
                binding.tvHotelDescription.text = it.aboutTheHotel.description
                binding.cvPhoto.viewPager.adapter = PagerAdapterForImages(MAIN, it.imageUrls)
                TabLayoutMediator(binding.cvPhoto.tabDots, binding.cvPhoto.viewPager) { _, _ -> }.attach()

                val peculiarities = it.aboutTheHotel.peculiarities
                binding.fblPeculiarities.removeAllViews()
                for (i in peculiarities){
                    val cardView = layoutInflater.inflate(R.layout.item_peculiarities, null) as CardView
                    val textView = cardView.findViewById<TextView>(R.id.tv_peculiarities)
                    textView.text = i
                    binding.fblPeculiarities.addView(cardView)
                }
                MAIN.nameHotel = it.name
            }
        }
    }

    override fun onResume() {
        super.onResume()
        MAIN.setItemsInToolbar(getString(R.string.hotel), false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}