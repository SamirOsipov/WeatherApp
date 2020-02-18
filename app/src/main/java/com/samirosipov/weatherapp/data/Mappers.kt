package com.samirosipov.weatherapp.data

import com.samirosipov.weatherapp.data.repository.*
import kotlin.math.roundToInt

fun WeatherResponse.mapToWeather(): WeatherData {
    return WeatherData(
        weather?.map { it.mapToWeatherCommon() } ?: emptyList(),
        main!!.mapToMainData(),
        wind!!.mapToWindData(),
        dt?:0,
        name.orEmpty()
    )
}

fun Weather.mapToWeatherCommon(): WeatherCommon {
    return WeatherCommon(
        id ?: 0,
        main.orEmpty(),
        description.orEmpty(),
        icon.orEmpty()
    )
}

fun Main.mapToMainData(): MainData {
    return MainData(
        temp?.minus(273.15)?.roundToInt()?:0,
        pressure?.times(0.7500616827)?.roundToInt()?:0,
        humidity?:0,
        temp_min?.minus(273.15)?.roundToInt()?:0,
        temp_max?.minus(273.15)?.roundToInt()?:0
    )
}

fun Wind.mapToWindData(): WindData {
    return WindData(
        speed?:0,
        degree?:0

    )
}