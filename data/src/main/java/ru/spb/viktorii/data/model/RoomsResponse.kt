package ru.spb.viktorii.data.model

data class RoomsResponse(val rooms: List<Rooms>) {
    data class Rooms(
        var id: Int,
        var name: String,
        var price: Int,
        var price_per: String,
        var peculiarities: List<String>,
        var image_urls: List<String>
        )
}