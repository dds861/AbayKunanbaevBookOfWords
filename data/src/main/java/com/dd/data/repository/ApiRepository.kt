package com.dd.data.repository

import com.dd.data.net.API
import com.dd.data.net.model.toDataModel
import com.dd.data.net.model.toDomainModel
import com.dd.domain.model.RequestMakalModel
import com.dd.domain.model.ResponseMakalModel
import com.dd.domain.model.RequestCategoryModel
import com.dd.domain.model.ResponseCategoryModel
import com.dd.domain.repository.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiLdaRepository() : Repository {

    private lateinit var api: API

    /**-------------------------------------------------------------------------------------------*/
    /**                                                                                           */
    /**                                  RETROFIT SERVICES                                        */
    /**                                                                                           */
    /**-------------------------------------------------------------------------------------------*/

    private var retrofit: Retrofit = createRetrofit()
        set(value) {
            field = value
            api = field.create(API::class.java)
        }

    init {
        retrofit = createRetrofit()
    }


    private fun createRetrofit(token: String? = null): Retrofit {

        return Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    /**-------------------------------------------------------------------------------------------*/
    /**                                                                                           */
    /**                                IMPLEMENTATIONS                                            */
    /**                                                                                           */
    /**-------------------------------------------------------------------------------------------*/


    override suspend fun getCategory(requestCategoryModel: RequestCategoryModel): ResponseCategoryModel {
        return api.getCategory(requestCategoryModel.toDataModel()).await().toDomainModel()
    }

    override suspend fun getMakal(requestMakalModel: RequestMakalModel): ResponseMakalModel {
        return api.getMakal(requestMakalModel.toDataModel()).await().toDomainModel()
    }
}