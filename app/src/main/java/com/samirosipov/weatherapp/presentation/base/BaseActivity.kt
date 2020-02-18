package com.samirosipov.weatherapp.presentation.base

import moxy.MvpAppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder

abstract class BaseActivity: MvpAppCompatActivity(), BaseView {

    protected abstract var navigatorHolder: NavigatorHolder

    protected abstract var navigator: Navigator

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}