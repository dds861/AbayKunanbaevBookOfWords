package com.dd.data.repository


import com.dd.domain.model.*
import com.dd.domain.repository.Repository
import kotlinx.coroutines.delay
import javax.security.auth.login.LoginException



class MockRepository : Repository {

    override suspend fun getCategory(requestCategoryModel: RequestCategoryModel): ResponseCategoryModel {
        return ResponseCategoryModel(
                result = "AnyText"
        )
    }

    override suspend fun getMakal(requestMakalModel: RequestMakalModel): ResponseMakalModel {
        return ResponseMakalModel(
                result = "AnyText"
        )
    }

    override suspend fun getSelectLanguage(requestSelectLanguageModel: RequestSelectLanguageModel): ResponseSelectLanguageModel {
        return ResponseSelectLanguageModel()
    }
}