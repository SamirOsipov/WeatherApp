package com.samirosipov.weatherapp.presentation.base

import com.samirosipov.weatherapp.presentation.utils.DisposeHolder
import com.samirosipov.weatherapp.presentation.utils.ResourceProvider
import moxy.MvpPresenter

abstract class BasePresenter<T : BaseView>(
    private val resourceProvider: ResourceProvider,
    private val disposeHolder: DisposeHolder
) : MvpPresenter<T>(), DisposeHolder by disposeHolder, ResourceProvider by resourceProvider {

    override fun onDestroy() {
        clearSubscriptions()
        super.onDestroy()
    }

}