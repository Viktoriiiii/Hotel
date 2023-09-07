package ru.spb.viktorii.domain.repository

import ru.spb.viktorii.domain.model.Booking

interface BookingRepository {
    suspend fun getBooking() : Booking
}