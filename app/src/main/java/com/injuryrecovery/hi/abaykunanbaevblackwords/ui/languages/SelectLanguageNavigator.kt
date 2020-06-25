package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseNavigator

class SelectLanguageNavigator(
        override val navController: NavController,
        private val activity: Activity)
    : BaseNavigator<SelectLanguageNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
    }
}