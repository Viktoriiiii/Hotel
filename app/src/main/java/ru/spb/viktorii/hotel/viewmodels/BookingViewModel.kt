package ru.spb.viktorii.hotel.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.spb.viktorii.domain.model.Booking
import ru.spb.viktorii.domain.usecase.GetBooking

class BookingViewModel(private val getBooking: GetBooking): ViewModel() {
    var booking = MutableLiveData<Booking>()

    suspend fun getBookingInfo() = viewModelScope.launch {
        booking.value = getBooking.execute()
    }
}