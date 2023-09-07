package ru.spb.viktorii.hotel.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.spb.viktorii.domain.model.Rooms
import ru.spb.viktorii.domain.usecase.GetInfoAboutRooms

class RoomViewModel (private val getInfoAboutRooms: GetInfoAboutRooms) : ViewModel() {
    var rooms = MutableLiveData<Rooms>()

    suspend fun getRooms() = viewModelScope.launch {
        rooms.value = getInfoAboutRooms.execute()
    }
}