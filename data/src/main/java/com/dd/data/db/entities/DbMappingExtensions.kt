package com.dd.data.db.entities

import com.dd.domain.model.LanguageModel
import com.dd.domain.model.ResponseSelectLanguageModel


fun List<LanguagesDbData>.toDomainModel(): ResponseSelectLanguageModel {
    return ResponseSelectLanguageModel(
            list = this.map { LanguageModel(numerical = it.language_id, text = it.language_text) }
    )
}






