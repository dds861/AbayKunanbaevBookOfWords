package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist

import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaBaseState
import com.dd.domain.model.TitleBlackWordModel


data class ChecklistState(
        val default: String = STRING_EMPTY,
        val languageName: LanguageName = LanguageName.KAZAKH,
        val list: List<TitleBlackWordModel> = listOf()
) : EmaBaseState

enum class LanguageName {
    KAZAKH,
    RUSSIAN,
    ENGLISH,
    DUTCH,
    PORTUGUESE,
    CHINESE
}