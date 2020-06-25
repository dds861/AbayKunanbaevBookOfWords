package com.injuryrecovery.hi.abaykunanbaevblackwords.model

import com.carmabs.ema.core.constants.STRING_EMPTY

data class ToolbarModel(
        val telegramButton: TelegramButton? = null,
        val searchButton: SearchButton? = null,
        val toolbarTitle: String = STRING_EMPTY,
        val toolbarTitleVisibility: Boolean = true,
        val toolbarLogoOrBackVisibility: Boolean = true,
        val toolbarVisibility: Boolean = true,
        val toolbarElevation: Boolean = false
) {
    data class SearchButton(
            val visibility: Boolean = true,
            val searchViewText: String = STRING_EMPTY,
            val setOnQueryTextFocusChangeListener: ((queryText: String) -> Unit)? = null
    )

    data class TelegramButton(
            val visibility: Boolean = true
    )
}