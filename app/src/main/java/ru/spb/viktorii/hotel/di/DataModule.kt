package ru.spb.viktorii.hotel.di

import org.koin.dsl.module
import ru.spb.viktorii.data.repository.HotelRepositoryImpl
import ru.spb.viktorii.domain.repository.HotelRepository

val dataModule = module {

    single <HotelRepository> {
        HotelRepositoryImpl(api = get())
    }
}