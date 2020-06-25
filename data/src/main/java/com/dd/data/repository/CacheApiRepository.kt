package com.dd.data.repository

import com.dd.domain.model.*
import com.dd.domain.repository.Repository

class CacheApiRepository(private val repository: Repository) : Repository {

    override suspend fun getCategory(requestCategoryModel: RequestCategoryModel): ResponseCategoryModel {
        return repository.getCategory(requestCategoryModel)
    }

    override suspend fun getMakal(requestMakalModel: RequestMakalModel): ResponseMakalModel {
        return repository.getMakal(requestMakalModel)
    }

    override suspend fun getSelectLanguage(requestSelectLanguageModel: RequestSelectLanguageModel): ResponseSelectLanguageModel {
        return repository.getSelectLanguage(requestSelectLanguageModel)
    }
}

