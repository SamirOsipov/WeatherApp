package com.samirosipov.weatherapp

import android.app.Application
import com.samirosipov.weatherapp.di.AppComponent
import com.samirosipov.weatherapp.di.DaggerAppComponent


class WeatherApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory()
            .create(this)
        appComponent.inject(this)
        super.onCreate()


    }
}