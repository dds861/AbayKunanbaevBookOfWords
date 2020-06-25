package com.injuryrecovery.hi.abaykunanbaevblackwords.base

import com.carmabs.ema.core.navigator.EmaNavigationState
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel

abstract class BaseToolbarsViewModel<T, NS : EmaNavigationState> : BaseViewModel<T, NS>() {
    lateinit var mainToolbarsVm: MainToolbarsViewModel

    override fun onResume(firstTime: Boolean) {
        super.onResume(firstTime)
        onConfigureToolbars(mainToolbarsVm)
    }

    abstract fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel)
}