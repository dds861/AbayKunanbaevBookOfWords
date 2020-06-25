package com.dd.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.repository.LocalStorageRepository

class GetLocalRandomMakalUseCase(private val repository: LocalStorageRepository)
    : EmaUseCase<Unit, ResponseMakalModel>() {
    override suspend fun useCaseFunction(input: Unit): ResponseMakalModel {
        return repository.getRandomMakal()
    }
}