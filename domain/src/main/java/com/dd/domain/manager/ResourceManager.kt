package com.dd.domain.manager

interface ResourceManager {
    fun getCategoryList(): List<String>
    fun getToolbarTitle(): String
    fun getToolbarTitleEnglish(): String
    fun getToolbarTitleKazakh(): String
    fun getToolbarTitleRussian(): String
    fun getToolbarTitlePortuguese(): String
    fun getToolbarTitleDutch(): String
    fun getToolbarTitleChinese(): String
}