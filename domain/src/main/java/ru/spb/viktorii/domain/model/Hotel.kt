package ru.spb.viktorii.domain.model

data class Hotel(
    var id: Int,
    var name: String,
    var address: String,
    var minimalPrice: Int,
    var priceForIt: String,
    var rating: Int,
    var ratingName: String,
    var imageUrls: List<String>,
    val aboutTheHotel: AboutTheHotel
) {
    data class AboutTheHotel(
        var description: String,
        var peculiarities: List<String>
    )
}


