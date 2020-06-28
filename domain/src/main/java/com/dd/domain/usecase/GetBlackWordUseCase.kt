package com.dd.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.dd.domain.model.RequestBlackWordModel
import com.dd.domain.model.ResponseBlackWordModel
import com.dd.domain.repository.LocalStorageRepository

class GetBlackWordUseCase(private val repository: LocalStorageRepository)
    : EmaUseCase<RequestBlackWordModel, ResponseBlackWordModel>() {

    override suspend fun useCaseFunction(input: RequestBlackWordModel): ResponseBlackWordModel {
        return repository.getBlackWord(input)
    }
}