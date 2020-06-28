package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseNavigator

class BlackWordNavigator(
        override val navController: NavController,
        private val activity: Activity)
    : BaseNavigator<BlackWordNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
    }
}