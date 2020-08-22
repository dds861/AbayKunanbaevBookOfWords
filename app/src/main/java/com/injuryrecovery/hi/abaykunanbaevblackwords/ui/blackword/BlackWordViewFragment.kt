package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
import android.view.View
import com.carmabs.ema.android.extension.toDateFormat
import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaExtraData
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.LanguageName
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_black_word.*
import org.kodein.di.generic.instance

class BlackWordViewFragment
    : BaseToolbarsFragment<BlackWordState, BlackWordViewModel, BlackWordNavigator.Navigation>() {
    companion object {
        private const val CLIPBOARD_LABEL = "Copied String"
        private const val CLIPBOARD_FIRST_TEXT_IN_BUFFER = 0
        private const val DATE_FORMAT_YYYY = "yyyy"
    }

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
    private var previouslyCopiedText = STRING_EMPTY

    /**
     * Default functions
     */
    override fun onInitializedWithToolbarsManagement(viewModel: BlackWordViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        setListenerToClipboard()
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: BlackWordState) {
        when (data.languageName) {
            LanguageName.PORTUGUESE -> showLegalTextPortuguese()
            LanguageName.DUTCH -> showLegalTextDutch()
            LanguageName.CHINESE -> showLegalTextChinese()
            else -> hideLegalText()
        }
        tvBlackWord.text = data.blackWord

        if (data.copyClicked) {
            copyText(data.languageName)
        }
    }

    override fun onError(error: Throwable) {}

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

    private fun showLegalTextPortuguese() {
        tvLegalText.text = resources.getString(R.string.portugueseLegalText, getCurrentYear())
        tvLegalText.visibility = View.VISIBLE
    }

    private fun showLegalTextDutch() {
        tvLegalText.text = resources.getString(R.string.dutchLegalText, getCurrentYear())
        tvLegalText.visibility = View.VISIBLE
    }

    private fun showLegalTextChinese() {
        tvLegalText.text = resources.getString(R.string.chineseLegalText, getCurrentYear())
        tvLegalText.visibility = View.VISIBLE
    }

    private fun hideLegalText() {
        tvLegalText.visibility = View.GONE
    }

    private fun setListenerToClipboard() {
        val clipboardManager = context?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clipboardManager.addPrimaryClipChangedListener { vm.copyClicked() }
    }

    private fun copyText(languageName: LanguageName) {
        val clipboardManager = context?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val copiedString = clipboardManager.primaryClip?.getItemAt(CLIPBOARD_FIRST_TEXT_IN_BUFFER)?.text.toString()
        if (copiedString != previouslyCopiedText) {
            val copyrightText = getCopyrightText(copiedString, languageName)
            val clip = ClipData.newPlainText(CLIPBOARD_LABEL, copyrightText)
            clipboardManager.setPrimaryClip(clip)
            previouslyCopiedText = copyrightText
        }
    }

    private fun getCopyrightText(copiedString: String, languageName: LanguageName): String {
        val copyrightText = when (languageName) {
            LanguageName.PORTUGUESE,
            LanguageName.DUTCH,
            LanguageName.CHINESE -> " ©"
            else -> STRING_EMPTY
        }

        return "$copiedString$copyrightText"
    }

    private fun getCurrentYear(): String {
        return System.currentTimeMillis().toDateFormat(DATE_FORMAT_YYYY);
    }
}
