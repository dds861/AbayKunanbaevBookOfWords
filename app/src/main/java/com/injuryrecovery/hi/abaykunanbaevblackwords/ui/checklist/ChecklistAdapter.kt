package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist

import android.content.Context
import android.view.View
import android.widget.TextView
import com.carmabs.ema.android.ui.EmaRecyclerAdapter
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.dd.domain.model.TitleBlackWordModel
import kotlinx.android.synthetic.main.item_checklist.view.*

class ChecklistAdapter(private val context: Context,
                       override val listItems: MutableList<TitleBlackWordModel> = mutableListOf(),
                       private val itemListener: (TitleBlackWordModel) -> Unit) : EmaRecyclerAdapter<TitleBlackWordModel>() {
    override val layoutItemId: Int = com.injuryrecovery.hi.abaykunanbaevblackwords.R.layout.item_checklist

    override fun View.bind(item: TitleBlackWordModel, viewType: Int) {
        tvBlackWordItem.text = item.numerical

        tvBlackWordItem.setOnClickListener {
            makeAnimationOnClick(tvBlackWordItem)
            itemListener.invoke(item)
        }
    }

    private fun makeAnimationOnClick(textView: TextView) {
        YoYo.with(Techniques.FadeOut).duration(150).repeat(0).playOn(textView)
        YoYo.with(Techniques.FadeIn).duration(350).repeat(0).playOn(textView)
    }
}