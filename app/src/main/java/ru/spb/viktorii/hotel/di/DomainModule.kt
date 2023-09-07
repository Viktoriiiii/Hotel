package ru.spb.viktorii.hotel.di

import org.koin.dsl.module
import ru.spb.viktorii.domain.usecase.GetBooking
import ru.spb.viktorii.domain.usecase.GetInfoAboutHotel
import ru.spb.viktorii.domain.usecase.GetInfoAboutRooms

val domainModule = module {
    factory {
        GetInfoAboutHotel(hotelRepository = get())
    }
    factory {
        GetInfoAboutRooms(roomRepository = get())
    }
    factory {
        GetBooking(bookingRepository = get())
    }
}