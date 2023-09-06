package ru.spb.viktorii.hotel.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.spb.viktorii.data.network.HotelService
import ru.spb.viktorii.hotel.viewmodels.HotelViewModel

val appModule = module {

    viewModel {
        HotelViewModel(
            getInfoAboutHotel = get()
        )
    }
    single { provideHotelRetrofit()}
}

fun provideHotelRetrofit(): HotelService =
    Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HotelService::class.java)
