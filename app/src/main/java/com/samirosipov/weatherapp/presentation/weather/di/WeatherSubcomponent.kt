package com.samirosipov.weatherapp.presentation.weather.di

import com.samirosipov.weatherapp.presentation.weather.WeatherFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface WeatherSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(weatherFragment: WeatherFragment): Builder

        fun build(): WeatherSubcomponent
    }

    fun inject(weatherFragment: WeatherFragment)
}