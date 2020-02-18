package com.samirosipov.weatherapp.presentation.base

import androidx.annotation.LayoutRes
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpAppCompatFragment

abstract class BaseFragment(@LayoutRes contentLayout: Int): MvpAppCompatFragment(contentLayout), BaseView {

    private val lifeCycleDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.unsubscribeOnDestroy(): Disposable {
        lifeCycleDisposable.add(this)
        return this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifeCycleDisposable.clear()

    }

    override fun onDestroy() {
        super.onDestroy()
        lifeCycleDisposable.dispose()
    }
}