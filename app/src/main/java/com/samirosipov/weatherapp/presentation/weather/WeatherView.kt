package com.samirosipov.weatherapp.presentation.weather

import com.samirosipov.weatherapp.data.repository.WeatherResponse
import com.samirosipov.weatherapp.presentation.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface WeatherView: BaseView {

    fun showWeather(weatherResponse: WeatherResponse)
}