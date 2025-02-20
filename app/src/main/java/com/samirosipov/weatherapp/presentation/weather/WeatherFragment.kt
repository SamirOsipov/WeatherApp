package com.samirosipov.weatherapp.presentation.weather

import android.os.Bundle
import com.samirosipov.weatherapp.R
import com.samirosipov.weatherapp.data.repository.WeatherData
import com.samirosipov.weatherapp.presentation.MainActivity
import com.samirosipov.weatherapp.presentation.base.BaseFragment
import com.samirosipov.weatherapp.presentation.weather.di.WeatherSubcomponent
import kotlinx.android.synthetic.main.fragment_current_weather.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

const val DEGREE_SYMBOL = "°C"
const val SPEED_SYMBOL = "km/h"
const val DISTANCE_SYMBOL = "km"
class WeatherFragment: BaseFragment(R.layout.fragment_current_weather), WeatherView {

    companion object {
        fun getInstance() = WeatherFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var weatherPresenter: WeatherPresenter

    @ProvidePresenter
    fun provideWeatherPresenter(): WeatherPresenter = weatherPresenter

    lateinit var weatherSubcomponent: WeatherSubcomponent

    override fun onCreate(savedInstanceState: Bundle?) {
        weatherSubcomponent = (activity as MainActivity)
            .mainSubComponent
            .weatherSubcomponent()
            .withFragment(this)
            .build()
        weatherSubcomponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun showWeather(weatherData: WeatherData) {
        address.text = "${weatherData.name}"
        updated_at.text = "${weatherData.dt}"
        status.text = "${weatherData.weatherCommon[0].description}"
        temp.text = "${weatherData.main?.temperature} $DEGREE_SYMBOL"
        temp_max.text = "${weatherData.main?.temperature_max} $DEGREE_SYMBOL"
        temp_min.text = "${weatherData.main?.temperature_min} $DEGREE_SYMBOL"
        humidity.text = "${weatherData.main.humidity}%"
        pressure.text = "${weatherData.main.pressure}"
        wind.text = "${weatherData.wind.speed} $SPEED_SYMBOL"
        sunrise.text = "${weatherData.system.sunrise}"
        sunset.text = "${weatherData.system.sunset}"
        visibility.text = "${weatherData.visibility} $DISTANCE_SYMBOL"
    }
}