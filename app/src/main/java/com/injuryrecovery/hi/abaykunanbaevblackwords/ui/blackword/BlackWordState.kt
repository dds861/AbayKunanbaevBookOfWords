package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword

import com.carmabs.ema.core.constants.INT_ZERO
import com.carmabs.ema.core.constants.STRING_EMPTY
import com.carmabs.ema.core.state.EmaBaseState
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.LanguageName

data class BlackWordState(
        val position: Int = INT_ZERO,
        val languageName: LanguageName = LanguageName.KAZAKH,
        val blackWord: String = STRING_EMPTY
) : EmaBaseState