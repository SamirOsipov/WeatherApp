package com.samirosipov.weatherapp.presentation.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

interface DisposeHolder {
    fun Disposable.unsubscribeOnDestroy()

    fun clearSubscriptions()
}

class DisposeHolderImpl @Inject constructor() : DisposeHolder {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun Disposable.unsubscribeOnDestroy() {
        compositeDisposable.add(this)
    }

    override fun clearSubscriptions() {
        compositeDisposable.dispose()
    }
}