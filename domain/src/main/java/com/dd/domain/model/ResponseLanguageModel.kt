package com.dd.domain.model

import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaModel

data class ResponseSelectLanguageModel(
        val list: List<LanguageModel> = listOf()
)

data class LanguageModel(
        val numerical: String = STRING_EMPTY,
        val text: String = STRING_EMPTY
) : EmaModel