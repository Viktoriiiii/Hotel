package ru.spb.viktorii.hotel.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.spb.viktorii.data.network.HotelService
import ru.spb.viktorii.data.network.RoomService
import ru.spb.viktorii.hotel.BASE_URL
import ru.spb.viktorii.hotel.viewmodels.HotelViewModel
import ru.spb.viktorii.hotel.viewmodels.RoomViewModel

val appModule = module {

    viewModel { HotelViewModel(getInfoAboutHotel = get()) }
    viewModel { RoomViewModel(getInfoAboutRooms = get()) }

    single { provideHotelRetrofit()}
    single { provideRoomRetrofit() }
}

fun provideHotelRetrofit(): HotelService =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HotelService::class.java)

fun provideRoomRetrofit(): RoomService =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RoomService::class.java)