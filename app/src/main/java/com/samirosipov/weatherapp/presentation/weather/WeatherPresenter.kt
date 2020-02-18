package com.samirosipov.weatherapp.presentation.weather

import com.samirosipov.weatherapp.domain.WeatherUseCase
import com.samirosipov.weatherapp.presentation.base.BasePresenter
import com.samirosipov.weatherapp.presentation.utils.DisposeHolder
import com.samirosipov.weatherapp.presentation.utils.ResourceProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class WeatherPresenter @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val disposeHolder: DisposeHolder,
    private val weatherUseCase: WeatherUseCase
): BasePresenter<WeatherView>(resourceProvider, disposeHolder) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        showData()
    }

    private fun showData() {
        weatherUseCase.getWeatherData("Krasnodar")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                viewState.showWeather(it)
            }, {
                Timber.e(it)
            }).unsubscribeOnDestroy()
    }

}