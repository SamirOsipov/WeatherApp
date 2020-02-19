package com.samirosipov.weatherapp.data

import com.samirosipov.weatherapp.data.repository.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

fun WeatherResponse.mapToWeather(): WeatherData {
    return WeatherData(
        weather?.map { it.mapToWeatherCommon() } ?: emptyList(),
        main!!.mapToMainData(),
        visibility?.div(1000)?:0,
        wind!!.mapToWindData(),
        timeFormatterFull(dt?:System.currentTimeMillis()),
        sys!!.mapToSystemData(),
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
        temp?.minus(273.15)?.roundToInt() ?: 0,
        pressure?.times(0.7500616827)?.roundToInt() ?: 0,
        humidity ?: 0,
        temp_min?.minus(273.15)?.roundToInt() ?: 0,
        temp_max?.minus(273.15)?.roundToInt() ?: 0
    )
}

fun Wind.mapToWindData(): WindData {
    return WindData(
        speed ?: 0,
        degree ?: 0

    )
}

fun Sys.mapToSystemData(): SystemData {
    return SystemData(
        country.orEmpty(),
        timeFormatterShort(sunrise?:System.currentTimeMillis()),
        timeFormatterShort(sunset?:System.currentTimeMillis())
    )
}

fun timeFormatterShort(seconds: Long): String {
    val dateFormat = SimpleDateFormat("HH:MM", Locale.ENGLISH)
    val date = Date(seconds * 1000)
    return dateFormat.format(date)
}

fun timeFormatterFull(seconds: Long): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH)
    val date = Date(seconds * 1000)
    return dateFormat.format(date)
}



