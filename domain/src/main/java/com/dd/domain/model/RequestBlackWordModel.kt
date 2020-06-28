package com.dd.domain.model

import com.carmabs.ema.core.constants.INT_ZERO

data class RequestBlackWordModel(
        val position: Int = INT_ZERO,
        val languageName: LanguageName = LanguageName.KAZAKH
)