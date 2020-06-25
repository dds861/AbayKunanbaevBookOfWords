package com.injuryrecovery.hi.abaykunanbaevblackwords.base

import com.carmabs.ema.android.viewmodel.EmaViewModel
import com.carmabs.ema.core.navigator.EmaNavigationState

abstract class BaseViewModel<S, NS : EmaNavigationState> : EmaViewModel<S, NS> (){

    override fun onResume(firstTime: Boolean) {
        //Override if you want to do some task everytime the view goes
        //to foreground
    }
}