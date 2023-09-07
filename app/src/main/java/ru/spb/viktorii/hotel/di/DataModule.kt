package ru.spb.viktorii.hotel.di

import org.koin.dsl.module
import ru.spb.viktorii.data.repository.BookingRepositoryImpl
import ru.spb.viktorii.data.repository.HotelRepositoryImpl
import ru.spb.viktorii.data.repository.RoomRepositoryImpl
import ru.spb.viktorii.domain.repository.BookingRepository
import ru.spb.viktorii.domain.repository.HotelRepository
import ru.spb.viktorii.domain.repository.RoomRepository

val dataModule = module {

    single <HotelRepository> {
        HotelRepositoryImpl(api = get())
    }
    single <RoomRepository> {
        RoomRepositoryImpl(api = get())
    }
    single <BookingRepository> {
        BookingRepositoryImpl(api = get())
    }
}