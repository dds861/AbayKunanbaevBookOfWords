package com.injuryrecovery.hi.abaykunanbaevblackwords.model

import com.carmabs.ema.core.constants.STRING_EMPTY

data class ToolbarModel(
        val shareButton: ShareButton? = null,
        val title: String = STRING_EMPTY,
        val titleVisibility: Boolean = true,
        val logoOrBackVisibility: Boolean = true,
        val visibility: Boolean = true,
        val elevation: Boolean = false,
        val gone: Boolean = true,
        val backClickListener: (() -> Unit)? = null,
        val backVisibility: Boolean = false
)

data class ShareButton(
        val visibility: Boolean = true
)
