package com.samirosipov.weatherapp.presentation

import com.samirosipov.weatherapp.presentation.base.BasePresenter
import com.samirosipov.weatherapp.presentation.navigation.GlobalRouter
import com.samirosipov.weatherapp.presentation.utils.DisposeHolder
import com.samirosipov.weatherapp.presentation.utils.ResourceProvider
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val disposeHolder: DisposeHolder,
    private val router: GlobalRouter
):
    BasePresenter<MainView>(resourceProvider, disposeHolder) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.navigateToWeather()

    }
}