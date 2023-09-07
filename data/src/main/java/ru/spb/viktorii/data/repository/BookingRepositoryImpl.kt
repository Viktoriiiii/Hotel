package ru.spb.viktorii.data.repository

import ru.spb.viktorii.data.network.BookingService
import ru.spb.viktorii.domain.model.Booking
import ru.spb.viktorii.domain.repository.BookingRepository

class BookingRepositoryImpl(private val api: BookingService): BookingRepository {
    override suspend fun getBooking(): Booking {
        val from = api.getBooking()
        return Booking(
            id = from.id,
            hotelName = from.hotel_name,
            hotelAddress = from.hotel_adress,
            rating = from.horating,
            ratingName = from.rating_name,
            departure = from.departure,
            arrivalCountry = from.arrival_country,
            tourDateStart = from.tour_date_start,
            tourDateStop = from.tour_date_stop,
            numberOfNights = from.number_of_nights,
            room = from.room,
            nutrition = from.nutrition,
            tourPrice = from.tour_price,
            fuelCharge = from.fuel_charge,
            serviceCharge = from.service_charge
        )
    }
}