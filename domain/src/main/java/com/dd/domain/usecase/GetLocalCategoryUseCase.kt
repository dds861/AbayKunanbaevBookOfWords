package com.dd.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.ResponseCategoryModel
import com.dd.domain.repository.LocalStorageRepository
import com.dd.domain.repository.Repository

class GetLocalCategoryUseCase(private val repository: LocalStorageRepository)
    : EmaUseCase<RequestCategoryModel, ResponseCategoryModel>() {

    override suspend fun useCaseFunction(input: RequestCategoryModel): ResponseCategoryModel {
        return repository.getAllCategories(input)
    }
}


