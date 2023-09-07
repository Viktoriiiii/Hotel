package ru.spb.viktorii.data.repository

import ru.spb.viktorii.data.network.RoomService
import ru.spb.viktorii.domain.model.Rooms
import ru.spb.viktorii.domain.repository.RoomRepository

class RoomRepositoryImpl(private val api: RoomService): RoomRepository {
    override suspend fun getRooms(): Rooms {
        val fromList = api.getRooms()
        val toList = arrayListOf<Rooms.Room>()
        for (item in fromList.rooms) {
            val to = Rooms.Room(
                id = item.id,
                name = item.name,
                price = item.price,
                pricePer = item.price_per,
                peculiarities = item.peculiarities,
                imageUrls = item.image_urls
            )
            toList.add(to)
        }
        return Rooms(rooms = toList)
    }
}