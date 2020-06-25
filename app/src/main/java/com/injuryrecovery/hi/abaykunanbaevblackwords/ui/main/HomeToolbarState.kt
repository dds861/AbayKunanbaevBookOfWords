package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main

import com.carmabs.ema.core.state.EmaBaseState
import com.injuryrecovery.hi.abaykunanbaevblackwords.model.ToolbarModel

data class HomeToolbarState(
        val toolbarTitle: String? = null,
        val toolbarModel: ToolbarModel = ToolbarModel(),
        val step: HomeToolbarStateStep = HomeToolbarStateStep.UPDATE_TOOLBAR
) : EmaBaseState {

    enum class HomeToolbarStateStep {
        UPDATE_TOOLBAR,
        SHOW_INTERSTITIAL
    }
}