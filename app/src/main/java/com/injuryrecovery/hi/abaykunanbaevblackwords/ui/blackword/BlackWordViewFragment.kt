package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword

import com.carmabs.ema.core.state.EmaExtraData
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_black_word.*
import org.kodein.di.generic.instance

class BlackWordViewFragment
    : BaseToolbarsFragment<BlackWordState, BlackWordViewModel, BlackWordNavigator.Navigation>() {

    /**
     * Default variables
     */

    override val layoutId: Int = com.injuryrecovery.hi.abaykunanbaevblackwords.R.layout.fragment_black_word

    override val navigator: BlackWordNavigator by instance()

    override val viewModelSeed: BlackWordViewModel by instance()

    /**
     * Default functions
     */

    override fun onInitializedWithToolbarsManagement(viewModel: BlackWordViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: BlackWordState) {

        tvBlackWord.text = data.blackWord
    }

    override fun onError(error: Throwable){}

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

}
