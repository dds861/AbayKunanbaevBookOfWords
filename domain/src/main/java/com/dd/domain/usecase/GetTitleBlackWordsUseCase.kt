package com.dd.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.dd.domain.model.RequestTitleBlackWordsModel
import com.dd.domain.model.ResponseTitleBlackWordsModel
import com.dd.domain.repository.LocalStorageRepository

class GetTitleBlackWordsUseCase(private val repository: LocalStorageRepository)
    : EmaUseCase<RequestTitleBlackWordsModel, ResponseTitleBlackWordsModel>() {

    override suspend fun useCaseFunction(input: RequestTitleBlackWordsModel): ResponseTitleBlackWordsModel {
        return repository.getGetTitleBlackWords(input)
    }
}