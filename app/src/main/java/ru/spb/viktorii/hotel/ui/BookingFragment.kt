package ru.spb.viktorii.hotel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.spb.viktorii.hotel.R
import ru.spb.viktorii.hotel.adapters.TouristAdapter
import ru.spb.viktorii.hotel.databinding.FragmentBookingBinding
import ru.spb.viktorii.hotel.model.Tourist
import ru.spb.viktorii.hotel.utils.*
import ru.spb.viktorii.hotel.viewmodels.BookingViewModel
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

class BookingFragment : Fragment() {

    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!

    private val vmBooking: BookingViewModel by inject()
    private lateinit var touristAdapter: TouristAdapter

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
            if (touristAdapter.isDataComplete(binding.rvTourists))
                MAIN.navController.navigate(R.id.action_bookingFragment_to_orderPaidFragment)
            else
                Toast.makeText(MAIN, "Заполнены не все поля", Toast.LENGTH_SHORT).show()
        }
        showInfoAboutBooking()
        setMaskInPhoneEditText()

        binding.etPhone.onFocusChangeListener = FocusChangeListenerCheck(binding.cvPhone,
            FocusChangeListenerCheck.ValidationType.PHONE)
        binding.etMail.onFocusChangeListener = FocusChangeListenerCheck(binding.cvMail,
            FocusChangeListenerCheck.ValidationType.EMAIL)

        touristAdapter = TouristAdapter(arrayListOf(Tourist(0)))
        binding.rvTourists.adapter = touristAdapter

        binding.ivAddTourist.setOnClickListener {
            touristAdapter.addTourist(Tourist(1))
        }
    }

    private fun setMaskInPhoneEditText() {
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        mask.placeholder = '*'
        mask.isShowingEmptySlots = true
        mask.isForbidInputWhenFilled = true
        MaskFormatWatcher(mask).installOn(binding.etPhone)
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
                binding.tvTourPrice.text = it.tourPrice.toStringWithRubles()
                binding.tvFuelCharge.text = it.fuelCharge.toStringWithRubles()
                binding.tvServiceCharge.text = it.serviceCharge.toStringWithRubles()
                val totalCost = (it.fuelCharge + it.serviceCharge + it.tourPrice).toStringWithRubles()
                binding.tvToPay.text = totalCost
                binding.mbPay.text = getString(R.string.to_pay, totalCost)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}