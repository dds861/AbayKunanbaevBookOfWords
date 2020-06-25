package com.injuryrecovery.hi.abaykunanbaevblackwords.injection

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages.SelectLanguageViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun fragmentInjection(fragment: Fragment) = Kodein.Module(name = "FragmentModule") {
    bind<Fragment>() with singleton { fragment }

    bind<FragmentManager>() with singleton { fragment.requireActivity().supportFragmentManager }





    bind<SelectLanguageViewModel>() with provider { SelectLanguageViewModel(instance(), instance()) }

}