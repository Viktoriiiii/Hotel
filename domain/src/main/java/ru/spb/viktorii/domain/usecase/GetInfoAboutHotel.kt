package ru.spb.viktorii.domain.usecase

import ru.spb.viktorii.domain.model.Hotel
import ru.spb.viktorii.domain.repository.HotelRepository

class GetInfoAboutHotel(private val hotelRepository: HotelRepository) {
    suspend fun execute(): Hotel = hotelRepository.getHotel()
}