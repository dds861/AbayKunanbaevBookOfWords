package com.dd.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseCategoryModel
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.repository.LocalStorageRepository
import com.dd.domain.repository.Repository

class GetLocalMakalByCategoryIdUseCase(private val repository: LocalStorageRepository)
    : EmaUseCase<RequestMakalModel, ResponseMakalModel>() {

    override suspend fun useCaseFunction(input: RequestMakalModel): ResponseMakalModel {
        return repository.getMakalsByCategoryId(input)
    }
}


