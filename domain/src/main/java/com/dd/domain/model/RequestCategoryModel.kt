package com.dd.domain.model

import com.carmabs.ema.core.constants.INT_ZERO
import com.carmabs.ema.core.constants.STRING_EMPTY

data class RequestCategoryModel(
        val default: String = STRING_EMPTY,
        val categoryId: Int = INT_ZERO
)