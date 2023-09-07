package ru.spb.viktorii.hotel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.spb.viktorii.hotel.MAIN
import ru.spb.viktorii.hotel.R
import ru.spb.viktorii.hotel.databinding.FragmentBookingBinding
import ru.spb.viktorii.hotel.viewmodels.BookingViewModel

class BookingFragment : Fragment() {

    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!

    private val vmBooking: BookingViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MAIN.setItemsInToolbar(getString(R.string.booking), true)
        binding.mbPay.setOnClickListener {
            MAIN.navController.navigate(R.id.action_bookingFragment_to_orderPaidFragment)
        }
        showInfoAboutBooking()
    }

    private fun showInfoAboutBooking() {
        lifecycleScope.launch {
            vmBooking.getBookingInfo()
            vmBooking.booking.observe(this@BookingFragment){
                binding.tvGrade.text = String.format("${it.rating} ${it.ratingName}")
                binding.tvHotelName.text = it.hotelName
                binding.tvHotelAddress.text = it.hotelAddress
                binding.tvDeparture.text = it.departure
                binding.tvArrivalCountry.text = it.arrivalCountry
                binding.tvDates.text = String.format("${it.tourDateStart} - ${it.tourDateStop}")
                binding.tvNumberOfNights.text = String.format("${it.numberOfNights} ночей")
                binding.tvHotelNameInfo.text = it.hotelName
                binding.tvRoom.text = it.room
                binding.tvNutrition.text = it.nutrition
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}