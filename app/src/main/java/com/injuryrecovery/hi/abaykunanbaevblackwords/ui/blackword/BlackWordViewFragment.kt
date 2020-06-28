package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword

import android.view.View
import com.carmabs.ema.core.state.EmaExtraData
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.LanguageName
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_black_word.*
import org.kodein.di.generic.instance


class BlackWordViewFragment
    : BaseToolbarsFragment<BlackWordState, BlackWordViewModel, BlackWordNavigator.Navigation>() {

    /**
     * Default variables
     */

    override val layoutId: Int = R.layout.fragment_black_word

    override val navigator: BlackWordNavigator by instance()

    override val viewModelSeed: BlackWordViewModel by instance()

    /**
     * Custom variables
     */
    private lateinit var vm: BlackWordViewModel
    private val RECOVERY_DIALOG_REQUEST = 1

    /**
     * Default functions
     */

    override fun onInitializedWithToolbarsManagement(viewModel: BlackWordViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel

    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: BlackWordState) {
        when (data.languageName) {
            LanguageName.PORTUGUESE -> showLegalTextPortuguese()
            LanguageName.DUTCH -> showLegalTextDutch()
            else -> hideLegalText()
        }
        tvBlackWord.text = data.blackWord
    }

    override fun onError(error: Throwable) {}

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }


    private fun showLegalTextPortuguese() {
        tvLegalText.text = resources.getString(R.string.portugueseLegalText)
        tvLegalText.visibility = View.VISIBLE
    }

    private fun showLegalTextDutch() {
        tvLegalText.text = resources.getString(R.string.dutchLegalText)
        tvLegalText.visibility = View.VISIBLE
    }

    private fun hideLegalText() {
        tvLegalText.visibility = View.GONE
    }


}
