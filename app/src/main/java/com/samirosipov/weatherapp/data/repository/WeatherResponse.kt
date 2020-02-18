package com.samirosipov.weatherapp.data.repository

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse(

    @SerializedName("weather")
    @Expose
    var weather: List<Weather>?,

    @SerializedName("main")
    @Expose
    var main: Main?,

    @SerializedName("wind")
    @Expose
    val wind: Wind?,

    @SerializedName("dt")
    @Expose
    var dt: Long?,

    @SerializedName("name")
    var name: String?
)


data class Weather(

    @SerializedName("id")
    @Expose
    var id: Int?,

    @SerializedName("main")
    @Expose
    var main: String?,

    @SerializedName("description")
    @Expose
    var description: String?,

    @SerializedName("icon")
    @Expose
    var icon: String?
)

data class Main(

    @SerializedName("temp")
    @Expose
    var temp: Double?,

    @SerializedName("pressure")
    @Expose
    var pressure: Double?,

    @SerializedName("humidity")
    @Expose
    var humidity: Int?,

    @SerializedName("temp_min")
    @Expose
    var temp_min: Double?,

    @SerializedName("temp_max")
    @Expose
    var temp_max: Double?
)

data class Wind(

    @SerializedName("speed")
    @Expose
    val speed: Int?,

    @SerializedName("deg")
    @Expose
    val degree: Int?
)