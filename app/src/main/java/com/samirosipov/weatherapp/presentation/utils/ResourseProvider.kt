package com.samirosipov.weatherapp.presentation.utils

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

interface ResourceProvider {
    fun getString(@StringRes stringRes: Int): String
}

class ResourceProviderImpl @Inject constructor(private val context: Context) :
    ResourceProvider {
    override fun getString(@StringRes stringRes: Int) = context.getString(stringRes)
}