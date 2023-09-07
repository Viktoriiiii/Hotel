package ru.spb.viktorii.domain.model

data class Booking(
    var id: Int,
    var hotelName: String,
    var hotelAddress: String,
    var rating: Int,
    var ratingName: String,
    var departure: String,
    var arrivalCountry: String,
    var tourDateStart: String,
    var tourDateStop: String,
    var numberOfNights: Int,
    var room: String,
    var nutrition: String,
    var tourPrice: Int,
    var fuelCharge: Int,
    var serviceCharge: Int
)
