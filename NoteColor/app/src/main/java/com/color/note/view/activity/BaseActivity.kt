package com.color.note.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RelativeLayout
import com.color.note.R
import com.color.note.enum.Theme
import kotterknife.bindView

open class BaseActivity: AppCompatActivity() {
  var currentTheme: Theme = Theme.DEFAULT
  val background by bindView<RelativeLayout>(R.id.background)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // TODO get current theme from DB
    background.setBackgroundColor(currentTheme.backGroundColor)
  }
}