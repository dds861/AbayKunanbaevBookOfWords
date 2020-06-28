package com.injuryrecovery.hi.abaykunanbaevblackwords.injection

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.android.ui.EmaFragmentActivity
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.ChecklistNavigator
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages.LanguageNavigator
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.HomeNavigator
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun activityInjection(activity: Activity) = Kodein.Module(name = "ActivityModule") {
    bind<Activity>() with singleton { activity }

    bind<NavController>() with singleton { (activity as EmaFragmentActivity).let { it.navController } }

    bind<MainToolbarsViewModel>() with provider { MainToolbarsViewModel() }

    bind<HomeNavigator>() with singleton { HomeNavigator(instance(), instance()) }

    bind<LanguageNavigator>() with singleton { LanguageNavigator(instance(), instance()) }

    bind<ChecklistNavigator>() with singleton { ChecklistNavigator(instance(), instance()) }

}