package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseNavigator
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.ChecklistState

class LanguageNavigator(
        override val navController: NavController,
        private val activity: Activity)
    : BaseNavigator<LanguageNavigator.Navigation>() {


    sealed class Navigation : EmaNavigationState {
        class CheckList(private val makalState: ChecklistState) : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as LanguageNavigator
                nav.toChecklist(makalState)
            }
        }
    }

    private fun toChecklist(makalState: ChecklistState) {
        navigateWithAction(R.id.action_selectLanguageViewFragment_to_checklistViewFragment,
                addInputState(makalState))
    }
}

