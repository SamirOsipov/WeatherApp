package com.samirosipov.weatherapp.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class AppNavigator @JvmOverloads constructor(
    private val activity: FragmentActivity,
    private val fragmentManager: FragmentManager = activity.supportFragmentManager,
    private val containerId: Int
): SupportAppNavigator(activity, fragmentManager, containerId) {

    override fun applyCommand(command: Command?) {
        if (command is Exit) {
            exitFromApp()
        } else {
            super.applyCommand(command)
        }
    }

    private fun exitFromApp() {
        activity.finish()
    }
}