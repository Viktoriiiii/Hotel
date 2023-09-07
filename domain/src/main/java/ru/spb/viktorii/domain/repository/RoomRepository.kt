package ru.spb.viktorii.domain.repository

import ru.spb.viktorii.domain.model.Rooms

interface RoomRepository {
    suspend fun getRooms() : Rooms
}