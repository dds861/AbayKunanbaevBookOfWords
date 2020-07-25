package com.dd.data.manager

import android.content.Context
import com.dd.data.R
import com.dd.domain.manager.ResourceManager

class AndroidResourceManager(private val context: Context) : ResourceManager {
    override fun getCategoryList(): List<String> = listOf("a", "b", "d", "e", "f", "g", "h", "i")

    override fun getToolbarTitle(): String = context.resources.getString(R.string.home_toolbar_title)

    override fun getToolbarTitleEnglish(): String = context.resources.getString(R.string.englishBlackWordsTitle)
    override fun getToolbarTitleKazakh(): String = context.resources.getString(R.string.kazakhBlackWordsTitle)
    override fun getToolbarTitleRussian(): String = context.resources.getString(R.string.russianBlackWordsTitle)
    override fun getToolbarTitlePortuguese(): String = context.resources.getString(R.string.portugueseBlackWordsTitle)
    override fun getToolbarTitleDutch(): String = context.resources.getString(R.string.dutchBlackWordsTitle)
    override fun getToolbarTitleChinese(): String = context.resources.getString(R.string.chineseBlackWordsTitle)
}