package com.samirosipov.weatherapp.presentation.weather

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class WeatherScreen: SupportAppScreen() {

    override fun getFragment(): Fragment = WeatherFragment.getInstance()
}