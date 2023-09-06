package ru.spb.viktorii.data.repository

import ru.spb.viktorii.data.network.HotelService
import ru.spb.viktorii.domain.model.Hotel
import ru.spb.viktorii.domain.repository.HotelRepository

class HotelRepositoryImpl(private val api: HotelService) : HotelRepository {

    override suspend fun getHotel(): Hotel {
        val from = api.getHotel()
        return Hotel(
            id = from.id,
            name = from.name,
            address = from.adress,
            minimalPrice = from.minimal_price,
            priceForIt = from.price_for_it,
            rating = from.rating,
            ratingName = from.rating_name,
            imageUrls = from.image_urls,
            Hotel.AboutTheHotel(
                description = from.about_the_hotel.description,
                peculiarities = from.about_the_hotel.peculiarities
            )
        )
    }
}