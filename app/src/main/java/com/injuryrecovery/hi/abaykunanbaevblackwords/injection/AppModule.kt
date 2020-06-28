package com.injuryrecovery.hi.abaykunanbaevblackwords.injection

import android.app.Application
import com.dd.domain.usecase.*
import com.dd.domain.usecase.GetTitleBlackWordsUseCase
import com.dd.domain.usecase.GetBlackWordUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun appInjection(application: Application) = Kodein.Module(name = "AppModule") {
    bind<Application>() with singleton { application }

    bind<GetSelectLanguageUseCase>() with provider { GetSelectLanguageUseCase(instance()) }

    bind<GetTitleBlackWordsUseCase>() with provider { GetTitleBlackWordsUseCase(instance()) }

    bind<GetBlackWordUseCase>() with provider { GetBlackWordUseCase(instance()) }
}