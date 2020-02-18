package com.samirosipov.weatherapp.presentation.di

import com.samirosipov.weatherapp.di.scopes.ActivityScope
import com.samirosipov.weatherapp.presentation.MainActivity
import com.samirosipov.weatherapp.presentation.navigation.AppNavigator
import com.samirosipov.weatherapp.presentation.navigation.GlobalRouter
import com.samirosipov.weatherapp.presentation.navigation.GlobalRouterCiceroneImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Navigator


@Module
abstract class MainModule {

    @Module
    companion object {

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideNavigator(mainActivity: MainActivity): Navigator {
            return AppNavigator(mainActivity, containerId = mainActivity.getContainerId())
        }
    }

    @Binds
    @ActivityScope
    abstract fun provideGlobalRouter(globalRouterCiceroneImpl: GlobalRouterCiceroneImpl): GlobalRouter
}