package com.dd.domain.model

import com.carmabs.ema.core.constants.INT_ZERO
import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaModel

data class ResponseCategoryModel(
        val result: String = STRING_EMPTY,
        val list: List<CategoryModel> = listOf()
)

data class CategoryModel(
        val category_id: Int = INT_ZERO,
        val category_text: String = STRING_EMPTY
) : EmaModel