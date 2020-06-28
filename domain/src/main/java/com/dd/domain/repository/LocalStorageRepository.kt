package com.dd.domain.repository

import com.dd.domain.model.*

interface LocalStorageRepository {
    fun getAllLanguages(request: RequestSelectLanguageModel): ResponseSelectLanguageModel

    suspend fun getGetTitleBlackWords(requestTitleBlackWordsModel: RequestTitleBlackWordsModel): ResponseTitleBlackWordsModel

    suspend fun getBlackWord(requestBlackWordModel: RequestBlackWordModel): ResponseBlackWordModel
}