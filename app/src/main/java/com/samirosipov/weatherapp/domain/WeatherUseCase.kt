package com.samirosipov.weatherapp.domain

import com.samirosipov.weatherapp.data.repository.WeatherData
import com.samirosipov.weatherapp.data.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
){

    fun getWeatherData(city: String): Single<WeatherData> {
        return weatherRepository.getWeatherData(city)
    }
}