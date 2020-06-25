package com.dd.domain.repository

import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseCategoryModel
import com.dd.domain.model.ResponseMakalModel

interface LocalStorageRepository {
    fun getAllCategories(request: RequestCategoryModel): ResponseCategoryModel

    fun getAllMakals(request: RequestMakalModel): ResponseMakalModel

    fun getMakalsByCategoryId(request: RequestMakalModel): ResponseMakalModel

    fun getMakalsByQueryText(request: RequestMakalModel): ResponseMakalModel

    fun getRandomMakal(): ResponseMakalModel
}