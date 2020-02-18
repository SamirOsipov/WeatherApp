package com.samirosipov.weatherapp.presentation.di

import com.samirosipov.weatherapp.di.scopes.ActivityScope
import com.samirosipov.weatherapp.presentation.MainActivity
import com.samirosipov.weatherapp.presentation.weather.di.WeatherSubcomponent
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent(modules = [MainModule::class])
@ActivityScope
interface MainSubcomponent {

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withActivity(activity: MainActivity): Builder

        fun build(): MainSubcomponent
    }

    fun inject(mainActivity: MainActivity)

    fun weatherSubcomponent(): WeatherSubcomponent.Builder

}