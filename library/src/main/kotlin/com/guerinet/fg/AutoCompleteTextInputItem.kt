/*
 * Copyright 2015-2018 Julien Guerinet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guerinet.fg

import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Filterable
import android.widget.ListAdapter
import com.guerinet.formgenerator.FormGenerator

/**
 * Form item for a [TextInputItem] that has an autocomplete option
 * @author Julien Guerinet
 * @since 3.0.0
 */
class AutoCompleteTextInputItem(fg: FormGenerator, view: View) :
        TextInputItem<AutoCompleteTextInputItem, AutoCompleteTextView>(fg, view) {

    /**
     * Sets the [adapter] for the [AutoCompleteTextView] on the returned item
     */
    fun <T> adapter(adapter: T): AutoCompleteTextInputItem where T : ListAdapter, T : Filterable {
        childView.setAdapter(adapter)
        return this
    }

    /**
     * Sets the [threshold], i.e. number of characters that need to be typed before the options are
     *  displayed, on the returned item
     */
    fun threshold(threshold: Int): AutoCompleteTextInputItem {
        // If the threshold is 0, set an OnTouchListener to open the list when clicked
        if (threshold == 0) {
            childView.threshold = 1
            childView.setOnTouchListener({ _, _ ->
                childView.showDropDown()
                false
            })
        } else {
            childView.threshold = threshold
        }
        return this
    }
}