package ru.spb.viktorii.domain.model

data class Rooms (val rooms: List<Room>) {
    data class Room(
        var id: Int,
        var name: String,
        var price: Int,
        var pricePer: String,
        var peculiarities: List<String>,
        var imageUrls: List<String>
    )
}
