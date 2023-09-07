package ru.spb.viktorii.data.network

import retrofit2.http.GET
import ru.spb.viktorii.data.model.BookingResponse

interface BookingService {
    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBooking(): BookingResponse
}