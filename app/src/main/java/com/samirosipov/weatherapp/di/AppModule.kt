package com.samirosipov.weatherapp.di

import android.content.Context
import android.content.res.Resources
import com.samirosipov.weatherapp.di.scopes.PerApplication
import com.samirosipov.weatherapp.presentation.utils.DisposeHolder
import com.samirosipov.weatherapp.presentation.utils.DisposeHolderImpl
import com.samirosipov.weatherapp.presentation.utils.ResourceProvider
import com.samirosipov.weatherapp.presentation.utils.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @PerApplication
        fun provideResources(context: Context): Resources = context.resources
    }

    @Binds
    abstract fun provideResourceProvider(recourceProvider: ResourceProviderImpl): ResourceProvider

    @Binds
    abstract fun provideDisposeHolder(disposeHolderImpl: DisposeHolderImpl): DisposeHolder

}