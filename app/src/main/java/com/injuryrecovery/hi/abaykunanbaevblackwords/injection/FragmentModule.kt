package com.injuryrecovery.hi.abaykunanbaevblackwords.injection

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword.BlackWordViewModel
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.ChecklistViewModel
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages.LanguageViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun fragmentInjection(fragment: Fragment) = Kodein.Module(name = "FragmentModule") {
    bind<Fragment>() with singleton { fragment }

    bind<FragmentManager>() with singleton { fragment.requireActivity().supportFragmentManager }

    bind<LanguageViewModel>() with provider { LanguageViewModel(instance(), instance()) }

    bind<ChecklistViewModel>() with provider { ChecklistViewModel(instance(), instance()) }

    bind<BlackWordViewModel>() with provider { BlackWordViewModel(instance(), instance()) }

}