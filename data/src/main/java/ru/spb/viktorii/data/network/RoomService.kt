package ru.spb.viktorii.data.network

import retrofit2.http.GET
import ru.spb.viktorii.data.model.RoomsResponse

interface RoomService {
    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRooms(): RoomsResponse
}