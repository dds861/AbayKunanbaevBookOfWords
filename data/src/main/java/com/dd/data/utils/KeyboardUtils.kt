/*
 *  Copyright (c) 2017-present,  Created by Carlos Mateo Benito <apps.carmabs@gmail.com>.
 *
 *  Licensed under the Apache License, VersionModel 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is
 *  distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 */
package com.dd.data.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.carmabs.ema.core.constants.INT_ZERO

object KeyboardUtils {
    fun setOnClickHideSoftInput(activity: Activity, view: View) {
        view.isClickable = true
        view.setOnClickListener(OnHideSoftInputClickListener(activity))
    }

    fun hideSoftInput(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocus = activity.currentFocus
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken, INT_ZERO)
        }
    }

    fun hideKeyboard(activity: Activity, view: View?) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, INT_ZERO)
    }

    fun showKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    fun showKeyboard(activity: Activity, view: View) {
        val inputMethodManager = activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        inputMethodManager.showSoftInput(view, INT_ZERO)
        view.requestFocus()
    }

    class OnHideSoftInputClickListener(private val mActivity: Activity) : View.OnClickListener {
        override fun onClick(v: View) {
            hideSoftInput(mActivity)
        }
    }
}