package com.samirosipov.weatherapp.presentation

import android.os.Bundle
import com.samirosipov.weatherapp.R
import com.samirosipov.weatherapp.WeatherApp
import com.samirosipov.weatherapp.presentation.base.BaseActivity
import com.samirosipov.weatherapp.presentation.di.MainSubcomponent
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    override lateinit var navigatorHolder: NavigatorHolder

    @Inject
    override lateinit var navigator: Navigator

    @Inject
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = mainPresenter

    lateinit var mainSubComponent: MainSubcomponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainSubComponent = (application as WeatherApp)
            .appComponent
            .mainSubComponentBuilder()
            .withActivity(this)
            .build()
        mainSubComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getContainerId(): Int = R.id.containerMain
}
