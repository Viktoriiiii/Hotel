package ru.spb.viktorii.domain.usecase

import ru.spb.viktorii.domain.model.Rooms
import ru.spb.viktorii.domain.repository.RoomRepository

class GetInfoAboutRooms(private val roomRepository: RoomRepository) {
    suspend fun execute(): Rooms = roomRepository.getRooms()
}