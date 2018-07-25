package com.color.note.view.base_component

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.color.note.enum.Theme

class BaseTextView(context: Context, attributeSet: AttributeSet) : TextView(context, attributeSet) {
  init {
    // TODO get current theme
    var currentTheme = Theme.DEFAULT
    setTextColor(currentTheme.textColor)
  }
}