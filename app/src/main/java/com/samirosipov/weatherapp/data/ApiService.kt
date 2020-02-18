package com.samirosipov.weatherapp.data

import com.samirosipov.weatherapp.data.repository.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Single<WeatherResponse>
}