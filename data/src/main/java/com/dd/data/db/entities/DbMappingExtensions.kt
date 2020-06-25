package com.dd.data.db.entities

import com.dd.domain.model.CategoryModel
import com.dd.domain.model.MakalModel
import com.dd.domain.model.ResponseCategoryModel
import com.dd.domain.model.ResponseMakalModel

fun List<CategoryDbData>.toDomainModel(): ResponseCategoryModel {
    return ResponseCategoryModel(
            list = this.map { CategoryModel(category_id = it.category_id, category_text = it.category_text) }
    )
}

fun List<MakalDbData>.toDomainModel(): ResponseMakalModel {
    return ResponseMakalModel(
            list = this.map {
                MakalModel(
                        makal_id = it.category_id,
                        branch = it.makal_branch,
                        address = it.makal_address,
                        phone = it.makal_phone,
                        schedule = it.makal_schedule
                )
            }
    )
}

fun String.toDomainModel(): ResponseMakalModel {
    return ResponseMakalModel(
            randomMakal = this.replace("\\\\n".toRegex(), "\n")
    )
}
