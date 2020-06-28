package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.EditText
import com.carmabs.ema.android.extra.EmaReceiverModel
import com.carmabs.ema.android.extra.EmaResultModel
import com.carmabs.ema.android.ui.EmaView
import com.carmabs.ema.core.constants.FLOAT_ZERO
import com.carmabs.ema.core.state.EmaExtraData
import com.google.android.gms.ads.*
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseActivity
import com.injuryrecovery.hi.abaykunanbaevblackwords.model.ToolbarModel
import kotlinx.android.synthetic.main.item_banner_ad_container.*
import kotlinx.android.synthetic.main.toolbar.*
import org.kodein.di.generic.instance

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
    private val adSize: AdSize
        get() {
            //code from official Google Admobs
            val display = windowManager.defaultDisplay
            val outMetrics = DisplayMetrics()
            display.getMetrics(outMetrics)
            val density = outMetrics.density
            var adWidthPixels = avAdvertising.width.toFloat()
            if (adWidthPixels == 0f) {
                adWidthPixels = outMetrics.widthPixels.toFloat()
            }
            val adWidth = (adWidthPixels / density).toInt()
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth)
        }

    /**
     * Default functions
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel(this)

        setupMobileAds()
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
        if (checkToolbarVisibility(data)) {
            updateToolbar(data.toolbarModel)
        }
    }

    /**
     * Customs functions
     */


    private fun checkToolbarVisibility(data: HomeToolbarState): Boolean {
        val visibility = data.toolbarModel.visibility
        val gone = data.toolbarModel.gone

        if (visibility)
            showToolbar()
        else
            hideToolbar(gone)

        return visibility
    }

    private fun updateToolbar(data: ToolbarModel) {
        val title = data.title
        val backVisibility = if (data.backVisibility) View.VISIBLE else View.INVISIBLE
        if (title.isEmpty()) {
            tvToolbarTitle.visibility = View.GONE
            ivLogo.visibility = View.VISIBLE

        } else {
            ivLogo.visibility = View.GONE
            tvToolbarTitle.visibility = View.VISIBLE
        }

        toolbarLayout.elevation = FLOAT_ZERO

        tvToolbarTitle.text = title
        ivToolbarBack.visibility = backVisibility



        data.backClickListener?.let { listener ->
            ivToolbarBack.setOnClickListener { listener.invoke() }
        }
    }

    private fun setupMobileAds() {
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this)

        adView = AdView(this)
        avAdvertising.addView(adView)
        loadBanner()

    }

    private fun loadBanner() {
        adView.adUnitId = resources.getString(R.string.banner_ad_unit_id)

        adView.adSize = adSize
        val adRequest = AdRequest
                .Builder()
                .build()
        adView.loadAd(adRequest)
    }


}