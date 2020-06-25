package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.android.navigation.EmaNavigator
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState

class HomeNavigator(override val navController: NavController, val activity: Activity) : EmaNavigator<HomeNavigator.Navigation> {
    sealed class Navigation : EmaNavigationState {
        object Back : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as HomeNavigator
                nav.toBack()
            }
        }


    }

    private fun toBack() {
        if (!navigateBack())
            activity.finish()
    }


}