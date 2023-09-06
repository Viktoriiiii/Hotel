package ru.spb.viktorii.domain.repository

import ru.spb.viktorii.domain.model.Hotel

interface HotelRepository {
    suspend fun getHotel(): Hotel
}