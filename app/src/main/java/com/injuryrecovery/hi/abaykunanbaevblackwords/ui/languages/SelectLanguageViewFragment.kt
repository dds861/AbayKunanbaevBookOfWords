package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import com.carmabs.ema.core.state.EmaExtraData
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import org.kodein.di.generic.instance

class SelectLanguageViewFragment
    : BaseToolbarsFragment<SelectLanguageState, SelectLanguageViewModel, SelectLanguageNavigator.Navigation>() {

    /**
     * Default variables
     */

    override val layoutId: Int = R.layout.fragment_select_language

    override val navigator: SelectLanguageNavigator by instance()

    override val viewModelSeed: SelectLanguageViewModel by instance()

    /**
     * Default functions
     */

    override fun onInitializedWithToolbarsManagement(viewModel: SelectLanguageViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: SelectLanguageState) {
    }



    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
        TODO("Not yet implemented")
    }

    override fun onError(error: Throwable) {

    }

}
