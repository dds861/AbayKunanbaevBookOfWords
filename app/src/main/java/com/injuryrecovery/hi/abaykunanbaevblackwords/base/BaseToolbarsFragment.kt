package com.injuryrecovery.hi.abaykunanbaevblackwords.base

import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.state.EmaBaseState
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import org.kodein.di.generic.instance

abstract class BaseToolbarsFragment<S : EmaBaseState, VM : BaseToolbarsViewModel<S, NS>, NS : EmaNavigationState>
    : BaseFragment<S, VM, NS>() {
    lateinit var mainToolbarsVm: MainToolbarsViewModel
    private val mainToolbarsViewModelSeed: MainToolbarsViewModel by instance()

    override fun onInitialized(viewModel: VM) {
        (viewModel as? BaseToolbarsViewModel<*, *>)?.also {
            mainToolbarsVm = addExtraViewModel(mainToolbarsViewModelSeed, this, requireActivity())
            it.mainToolbarsVm = mainToolbarsVm
            onInitializedWithToolbarsManagement(viewModel, mainToolbarsVm)
        } ?: throw RuntimeException("The view model must be inherited from BaseToolbarsViewModel")
    }

    abstract fun onInitializedWithToolbarsManagement(viewModel: VM, mainToolbarViewModel: MainToolbarsViewModel)
}