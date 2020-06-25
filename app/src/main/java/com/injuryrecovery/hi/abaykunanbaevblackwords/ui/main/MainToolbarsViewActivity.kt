package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main

import android.os.Bundle
import android.widget.EditText
import com.carmabs.ema.android.extra.EmaReceiverModel
import com.carmabs.ema.android.extra.EmaResultModel
import com.carmabs.ema.android.ui.EmaView
import com.carmabs.ema.core.state.EmaExtraData
import com.google.android.gms.ads.*
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseActivity
import org.kodein.di.generic.instance
import com.injuryrecovery.hi.abaykunanbaevblackwords.R

class MainToolbarsViewActivity : BaseActivity(), EmaView<HomeToolbarState, MainToolbarsViewModel, HomeNavigator.Navigation> {
    /**
     * Default variables
     */
    override val inputState: HomeToolbarState? = null
    override var previousState: HomeToolbarState? = null
    override val viewModelSeed: MainToolbarsViewModel by instance()
    override val navigator: HomeNavigator by instance()
    override val navGraph: Int = R.navigation.navigation_ema_home

    /**
     * Customs variables
     */
    lateinit var vm: MainToolbarsViewModel
    lateinit var etSearch: EditText
    private lateinit var adView: AdView
    private lateinit var mInterstitialAd: InterstitialAd
//    private val adSize: AdSize
//        get() {
//            //code from official Google Admobs
//            val display = windowManager.defaultDisplay
//            val outMetrics = DisplayMetrics()
//            display.getMetrics(outMetrics)
//            val density = outMetrics.density
//            var adWidthPixels = avAdvertising.width.toFloat()
//            if (adWidthPixels == 0f) {
//                adWidthPixels = outMetrics.widthPixels.toFloat()
//            }
//            val adWidth = (adWidthPixels / density).toInt()
//            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth)
//        }

    /**
     * Default functions
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel(this)

//        setupMobileAds()
    }

    override fun onResultReceiverInvokeEvent(emaReceiverModel: EmaReceiverModel) {
    }

    override fun onResultSetEvent(emaResultModel: EmaResultModel) {
    }

    override fun onViewModelInitialized(viewModel: MainToolbarsViewModel) {
//        setupToolbar(viewModel)
    }

    override fun provideFixedToolbarTitle(): String? = null

    override fun onStateAlternative(data: EmaExtraData) {
    }

    override fun onSingleEvent(data: EmaExtraData) {
        if (etSearch.text.toString() != data.extraData.toString()) {
            etSearch.setText(data.extraData.toString())
        }
    }

    override fun onStateError(error: Throwable) {
    }

    override fun onStateNormal(data: HomeToolbarState) {
//        when (data.step) {
//            HomeToolbarState.HomeToolbarStateStep.UPDATE_TOOLBAR -> {
//                updateToolbar(data.toolbarModel)
//            }
//
//            HomeToolbarState.HomeToolbarStateStep.SHOW_INTERSTITIAL -> {
//                showInterstitial()
//            }
//        }
    }

    /**
     * Customs functions
     */
//    private fun setupMobileAds() {
//        // Initialize the Mobile Ads SDK.
//        MobileAds.initialize(this)
//
//        adView = AdView(this)
//        avAdvertising.addView(adView)
//        loadBanner()
//
//        mInterstitialAd = InterstitialAd(this)
//        mInterstitialAd.adUnitId = resources.getString(R.string.interstitial_ad_unit_id)
//        mInterstitialAd.loadAd(AdRequest.Builder().build())
//
//        mInterstitialAd.adListener = object : AdListener() {
//            override fun onAdClosed() {
//                mInterstitialAd.loadAd(AdRequest.Builder().build())
//                etSearch.clearFocus()
//            }
//        }
//    }
//
//
//    private fun loadBanner() {
//        adView.adUnitId = resources.getString(R.string.banner_ad_unit_id)
//
//        adView.adSize = adSize
//        val adRequest = AdRequest
//                .Builder()
//                .build()
//        adView.loadAd(adRequest)
//    }


}