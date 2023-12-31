package ru.spb.viktorii.data.model

data class BookingResponse (
    var id: Int,
    var hotel_name: String,
    var hotel_adress: String,
    var horating: Int,
    var rating_name: String,
    var departure: String,
    var arrival_country: String,
    var tour_date_start: String,
    var tour_date_stop: String,
    var number_of_nights: Int,
    var room: String,
    var nutrition: String,
    var tour_price: Int,
    var fuel_charge: Int,
    var service_charge: Int
)