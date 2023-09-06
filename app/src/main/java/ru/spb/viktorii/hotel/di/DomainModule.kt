package ru.spb.viktorii.hotel.di

import org.koin.dsl.module
import ru.spb.viktorii.domain.usecase.GetInfoAboutHotel

val domainModule = module {
    factory {
        GetInfoAboutHotel(hotelRepository = get())
    }
}