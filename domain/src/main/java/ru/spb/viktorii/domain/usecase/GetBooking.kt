package ru.spb.viktorii.domain.usecase

import ru.spb.viktorii.domain.model.Booking
import ru.spb.viktorii.domain.repository.BookingRepository

class GetBooking(private val bookingRepository: BookingRepository) {
    suspend fun execute(): Booking = bookingRepository.getBooking()
}