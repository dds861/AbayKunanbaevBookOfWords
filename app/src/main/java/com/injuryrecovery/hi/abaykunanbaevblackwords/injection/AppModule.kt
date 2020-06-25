package com.injuryrecovery.hi.abaykunanbaevblackwords.injection

import android.app.Application
import com.dd.domain.usecase.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun appInjection(application: Application) = Kodein.Module(name = "AppModule") {
    bind<Application>() with singleton { application }

    bind<GetCategoryUseCase>() with provider { GetCategoryUseCase(instance()) }

    bind<GetMakalUseCase>() with provider { GetMakalUseCase(instance()) }

    bind<GetLocalCategoryUseCase>() with provider { GetLocalCategoryUseCase(instance()) }

    bind<GetLocalMakalUseCase>() with provider { GetLocalMakalUseCase(instance()) }

    bind<GetLocalMakalByCategoryIdUseCase>() with provider { GetLocalMakalByCategoryIdUseCase(instance()) }

    bind<GetLocalMakalByQueryTextUseCase>() with provider { GetLocalMakalByQueryTextUseCase(instance()) }

    bind<GetLocalRandomMakalUseCase>() with provider { GetLocalRandomMakalUseCase(instance()) }




    bind<GetSelectLanguageUseCase>() with provider { GetSelectLanguageUseCase(instance()) }
}