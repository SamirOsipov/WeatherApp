package com.samirosipov.weatherapp.data.repository

data class WeatherData(

    val weatherCommon: List<WeatherCommon>,

    val main: MainData,

    val wind: WindData,

    val dt: Long,

    val name: String
)

data class WeatherCommon(
    val id: Int,

    val main: String,

    val description: String,

    val icon: String
)

data class MainData(
    val temperature: Int,

    val pressure: Int,

    val humidity: Int,

    val temperature_min: Int,

    val temperature_max: Int
)

data class WindData(

    val speed: Int,

    val degree: Int
)