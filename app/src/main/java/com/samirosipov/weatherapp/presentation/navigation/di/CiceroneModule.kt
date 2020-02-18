package com.samirosipov.weatherapp.presentation.navigation.di

import com.samirosipov.weatherapp.di.scopes.PerApplication
import com.samirosipov.weatherapp.presentation.navigation.GlobalRouterCiceroneImpl
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

@Module
class CiceroneModule {

    @Provides
    @PerApplication
    fun provideGlobalCiceroneRouter(): GlobalRouterCiceroneImpl = GlobalRouterCiceroneImpl()

    @Provides
    @PerApplication
    fun provideCicerone(ciceroneRouter: GlobalRouterCiceroneImpl): Cicerone<GlobalRouterCiceroneImpl> {
        return Cicerone.create(ciceroneRouter)
    }

    @Provides
    @PerApplication
    fun provideNavigationHolder(cicerone: Cicerone<GlobalRouterCiceroneImpl>): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}