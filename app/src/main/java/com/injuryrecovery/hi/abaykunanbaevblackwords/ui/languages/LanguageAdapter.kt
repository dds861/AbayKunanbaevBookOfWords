package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import android.content.Context
import android.view.View
import android.widget.TextView
import com.carmabs.ema.android.ui.EmaRecyclerAdapter
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.dd.domain.model.LanguageModel
import kotlinx.android.synthetic.main.item_select_language.view.*

class LanguageAdapter(private val context: Context,
                      override val listItems: MutableList<LanguageModel> = mutableListOf(),
                      private val itemListener: (LanguageModel) -> Unit) : EmaRecyclerAdapter<LanguageModel>() {
    override val layoutItemId: Int = com.injuryrecovery.hi.abaykunanbaevblackwords.R.layout.item_select_language

    override fun View.bind(item: LanguageModel, viewType: Int) {
        tv_language.text = item.text

        tv_language.setOnClickListener {
            makeAnimationOnClick(tv_language)
            itemListener.invoke(item)
        }
    }

    private fun makeAnimationOnClick(tvLanguage: TextView) {
        YoYo.with(Techniques.FadeOut).duration(150).repeat(0).playOn(tvLanguage)
        YoYo.with(Techniques.FadeIn).duration(350).repeat(0).playOn(tvLanguage)
    }
}