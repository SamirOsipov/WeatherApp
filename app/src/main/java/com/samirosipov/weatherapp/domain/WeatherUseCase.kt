package com.samirosipov.weatherapp.domain

import com.samirosipov.weatherapp.data.repository.WeatherRepository
import com.samirosipov.weatherapp.data.repository.WeatherResponse
import io.reactivex.Single
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
){

    fun getWeatherData(city: String): Single<WeatherResponse> {
        return weatherRepository.getWeatherData(city)
    }
}