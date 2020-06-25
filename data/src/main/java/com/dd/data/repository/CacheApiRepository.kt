package com.dd.data.repository

import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.ResponseCategoryModel
import com.dd.domain.repository.Repository

class CacheApiRepository(private val repository: Repository) : Repository {

    override suspend fun getCategory(requestCategoryModel: RequestCategoryModel): ResponseCategoryModel {
        return repository.getCategory(requestCategoryModel)
    }

    override suspend fun getMakal(requestMakalModel: RequestMakalModel): ResponseMakalModel {
        return repository.getMakal(requestMakalModel)
    }
}

