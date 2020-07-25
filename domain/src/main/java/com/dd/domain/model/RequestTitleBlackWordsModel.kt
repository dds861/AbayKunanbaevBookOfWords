package com.dd.domain.model

import com.carmabs.ema.core.constants.STRING_EMPTY

data class RequestTitleBlackWordsModel(
        val language: LanguageName = LanguageName.KAZAKH
)


enum class LanguageName {
    KAZAKH,
    RUSSIAN,
    ENGLISH,
    DUTCH,
    PORTUGUESE,
    CHINESE
}