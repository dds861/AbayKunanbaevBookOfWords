package com.dd.data.net.model


import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.ResponseCategoryModel

fun ResponseCategoryApi.toDomainModel(): ResponseCategoryModel = ResponseCategoryModel(
        result = this.result
)

fun RequestCategoryModel.toDataModel(): RequestCategoryApi = RequestCategoryApi(
        default = this.default
)

fun ResponseMakalApi.toDomainModel(): ResponseMakalModel = ResponseMakalModel(
        result = this.result
)

fun RequestMakalModel.toDataModel(): RequestMakalApi = RequestMakalApi(
        default = this.default
)