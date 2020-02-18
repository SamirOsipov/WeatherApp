package com.samirosipov.weatherapp.data.repository

import com.samirosipov.weatherapp.BuildConfig
import com.samirosipov.weatherapp.data.ApiService
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun getWeatherData(city: String): Single<WeatherResponse> {
        return apiService.getWeather(city, apiKey = BuildConfig.ApiKey)

    }
}