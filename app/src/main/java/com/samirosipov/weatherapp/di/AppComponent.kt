package com.samirosipov.weatherapp.di

import android.content.Context
import com.samirosipov.weatherapp.WeatherApp
import com.samirosipov.weatherapp.di.scopes.PerApplication
import com.samirosipov.weatherapp.presentation.di.MainSubcomponent
import com.samirosipov.weatherapp.presentation.navigation.di.CiceroneModule
import dagger.BindsInstance
import dagger.Component

@PerApplication
@Component(modules = [AppModule::class, NetworkModule::class, CiceroneModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance appContext: Context): AppComponent
    }

    fun inject(app: WeatherApp)

    fun mainSubComponentBuilder(): MainSubcomponent.Builder
}