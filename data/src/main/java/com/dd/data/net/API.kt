package com.dd.data.net

import com.dd.data.net.model.RequestCategoryApi
import com.dd.data.net.model.RequestMakalApi
import com.dd.data.net.model.ResponseCategoryApi
import com.dd.data.net.model.ResponseMakalApi
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface API {

    @Headers(
            "Content-Type: application/x-www-form-urlencoded",
            "Accept-Charset: utf-8"
    )

    @POST("")
    fun getCategory(@Body request: RequestCategoryApi): Deferred<ResponseCategoryApi>

    @POST("")
    fun getMakal(@Body request: RequestMakalApi): Deferred<ResponseMakalApi>
}

