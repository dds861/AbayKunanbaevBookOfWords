package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaBaseState
import com.dd.domain.model.LanguageModel
import com.dd.domain.model.MakalModel

data class LanguageState(
        val languages: List<LanguageModel> = listOf()
) : EmaBaseState