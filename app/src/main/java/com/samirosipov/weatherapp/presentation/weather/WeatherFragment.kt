package com.samirosipov.weatherapp.presentation.weather

import android.os.Bundle
import com.samirosipov.weatherapp.R
import com.samirosipov.weatherapp.data.repository.WeatherResponse
import com.samirosipov.weatherapp.presentation.MainActivity
import com.samirosipov.weatherapp.presentation.base.BaseFragment
import com.samirosipov.weatherapp.presentation.weather.di.WeatherSubcomponent
import kotlinx.android.synthetic.main.fragment_current_weather.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

const val DEGREE_SYMBOL = "°C"
class WeatherFragment: BaseFragment(R.layout.fragment_current_weather), WeatherView {

    companion object {
        fun getInstance() = WeatherFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var weatherPresenter: WeatherPresenter

    @ProvidePresenter
    fun provideWeatherPresenter(): WeatherPresenter = weatherPresenter

    lateinit var weatherSubcomponent: WeatherSubcomponent

    override fun onCreate(savedInstanceState: Bundle?) {
        weatherSubcomponent = (activity as MainActivity)
            .mainSubComponent
            .weatherSubcomponent()
            .withFragment(this)
            .build()
        weatherSubcomponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun showWeather(weatherResponse: WeatherResponse) {
        temp.text = "${weatherResponse.main?.temp} $DEGREE_SYMBOL"
        temp_max.text = "${weatherResponse.main?.temp_max} $DEGREE_SYMBOL"
        temp_min.text = "${weatherResponse.main?.temp_min} $DEGREE_SYMBOL"

    }


}