package com.samirosipov.weatherapp.data.repository

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    @SerializedName("weather")
    @Expose
    val weather: List<Weather>?,

    @SerializedName("main")
    @Expose
    val main: Main?,

    @SerializedName("visibility")
    @Expose
    val visibility: Int?,

    @SerializedName("wind")
    @Expose
    val wind: Wind?,

    @SerializedName("dt")
    @Expose
    val dt: Long?,

    @SerializedName("sys")
    @Expose
    val sys: Sys?,

    @SerializedName("name")
    val name: String?
)


data class Weather(

    @SerializedName("id")
    @Expose
    val id: Int?,

    @SerializedName("main")
    @Expose
    val main: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("icon")
    @Expose
    val icon: String?
)

data class Main(

    @SerializedName("temp")
    @Expose
    val temp: Double?,

    @SerializedName("pressure")
    @Expose
    val pressure: Double?,

    @SerializedName("humidity")
    @Expose
    val humidity: Int?,

    @SerializedName("temp_min")
    @Expose
    val temp_min: Double?,

    @SerializedName("temp_max")
    @Expose
    val temp_max: Double?
)

data class Wind(

    @SerializedName("speed")
    @Expose
    val speed: Int?,

    @SerializedName("deg")
    @Expose
    val degree: Int?
)

data class Sys(
    @SerializedName("country")
    @Expose
    val country: String?,

    @SerializedName("sunrise")
    @Expose
    val sunrise: Long?,

    @SerializedName("sunset")
    @Expose
    val sunset: Long?

)