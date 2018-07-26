package com.color.note.view.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.color.note.R
import com.color.note.enum.Theme

class SectionNote(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {

  init {
    LayoutInflater.from(context).inflate(R.layout.component_section_note, this, true)

    // TODO get current theme
    var currentTheme = Theme.DEFAULT
  }
}