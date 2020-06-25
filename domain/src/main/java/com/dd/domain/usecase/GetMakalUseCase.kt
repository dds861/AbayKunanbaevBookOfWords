package com.dd.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.repository.Repository

class GetMakalUseCase(private val repository: Repository)
    : EmaUseCase<RequestMakalModel, ResponseMakalModel>() {

    override suspend fun useCaseFunction(input: RequestMakalModel): ResponseMakalModel {
        return repository.getMakal(input)
    }
}