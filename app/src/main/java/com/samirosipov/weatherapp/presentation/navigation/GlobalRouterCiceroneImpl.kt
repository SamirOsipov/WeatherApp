package com.samirosipov.weatherapp.presentation.navigation

import com.samirosipov.weatherapp.presentation.weather.WeatherScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class GlobalRouterCiceroneImpl @Inject constructor(): GlobalRouter, Router() {

    override fun navigateToWeather() {
        navigateTo(WeatherScreen())
    }
}