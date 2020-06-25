package com.dd.domain.repository

import com.dd.domain.model.*


interface Repository {

    suspend fun getCategory(requestCategoryModel: RequestCategoryModel): ResponseCategoryModel

    suspend fun getMakal(requestMakalModel: RequestMakalModel): ResponseMakalModel

    suspend fun getSelectLanguage(requestSelectLanguageModel: RequestSelectLanguageModel): ResponseSelectLanguageModel
}