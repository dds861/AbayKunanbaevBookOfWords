package com.dd.domain.model

import com.carmabs.ema.core.constants.INT_ZERO
import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaModel

data class ResponseMakalModel(
        val result: String = STRING_EMPTY,
        val randomMakal: String = STRING_EMPTY,
        val list: List<MakalModel> = listOf()
)

data class MakalModel(
        val makal_id: Int = INT_ZERO,
        val branch: String = STRING_EMPTY,
        val address: String? = STRING_EMPTY,
        val phone: String? = STRING_EMPTY,
        val schedule: String? = STRING_EMPTY
) : EmaModel
