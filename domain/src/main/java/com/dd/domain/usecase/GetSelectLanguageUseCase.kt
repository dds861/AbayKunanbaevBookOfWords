package com.dd.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.dd.domain.model.RequestSelectLanguageModel
import com.dd.domain.model.ResponseSelectLanguageModel
import com.dd.domain.repository.LocalStorageRepository
import com.dd.domain.repository.Repository

class GetSelectLanguageUseCase(private val repository: LocalStorageRepository)
    : EmaUseCase<RequestSelectLanguageModel, ResponseSelectLanguageModel>() {

    override suspend fun useCaseFunction(input: RequestSelectLanguageModel): ResponseSelectLanguageModel {
        return repository.getAllLanguages(input)
    }
}