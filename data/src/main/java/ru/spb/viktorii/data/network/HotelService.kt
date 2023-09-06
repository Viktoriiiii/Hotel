package ru.spb.viktorii.data.network

import retrofit2.http.GET
import ru.spb.viktorii.data.model.HotelResponse

interface HotelService {
    @GET("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotel(): HotelResponse
}