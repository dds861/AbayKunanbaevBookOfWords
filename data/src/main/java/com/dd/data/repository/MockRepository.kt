package com.dd.data.repository


import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.ResponseCategoryModel
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
}