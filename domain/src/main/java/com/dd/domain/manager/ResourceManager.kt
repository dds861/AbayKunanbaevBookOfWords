package com.dd.domain.manager

interface ResourceManager {
    fun getCategoryList(): List<String>
    fun getToolbarTitle(): String
}