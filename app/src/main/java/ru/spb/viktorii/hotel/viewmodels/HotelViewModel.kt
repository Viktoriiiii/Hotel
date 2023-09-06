package ru.spb.viktorii.hotel.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.spb.viktorii.domain.model.Hotel
import ru.spb.viktorii.domain.usecase.GetInfoAboutHotel

class HotelViewModel (private val getInfoAboutHotel: GetInfoAboutHotel) : ViewModel() {

    var hotel = MutableLiveData<Hotel>()

    suspend fun getHotel() = viewModelScope.launch {
        hotel.value = getInfoAboutHotel.execute()
    }
}