package com.dd.domain.model

import com.carmabs.ema.core.constants.INT_ZERO
import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaModel

data class ResponseTitleBlackWordsModel(
        val list: List<TitleBlackWordModel> = listOf()
)

data class TitleBlackWordModel(
        val position: Int = INT_ZERO,
        val numerical: String = STRING_EMPTY,
        val text: String = STRING_EMPTY
) : EmaModel