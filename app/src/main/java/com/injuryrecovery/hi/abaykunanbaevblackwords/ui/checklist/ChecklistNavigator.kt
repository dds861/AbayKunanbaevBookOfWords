package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseNavigator
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword.BlackWordState

class ChecklistNavigator(
        override val navController: NavController,
        private val activity: Activity)
    : BaseNavigator<ChecklistNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        class BlackWord(private val state: BlackWordState) : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as ChecklistNavigator
                nav.toBlackWord(state)
            }
        }
    }

    private fun toBlackWord(state: BlackWordState) {
        navigateWithAction(R.id.action_checklistViewFragment_to_blackWordViewFragment,
                addInputState(state))
    }
}