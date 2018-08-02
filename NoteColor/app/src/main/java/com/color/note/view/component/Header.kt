package com.color.note.view.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import com.color.note.R
import com.color.note.enum.Theme
import kotterknife.bindView

class Header(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet), OnClickListener {

  interface HeaderListener {
    fun onClickClose()
    fun onClickCheck()
  }

  val btnClose by bindView<ImageButton>(R.id.btn_close)
  val btnCheck by bindView<ImageButton>(R.id.btn_check)
  val txtTitle by bindView<TextView>(R.id.txt_title)

  private lateinit var listener: HeaderListener

  init {
    LayoutInflater.from(context).inflate(R.layout.header, this, true)

    // TODO get current theme
    var currentTheme = Theme.DEFAULT

    btnClose.setOnClickListener(this)
    btnCheck.setOnClickListener(this)
  }

  fun setOnClickHeaderListener(headerListener: HeaderListener) {
    this.listener = headerListener
  }

  override fun onClick(v: View?) {
    v ?: return
    when (v.id) {
      R.id.btn_close -> {
        listener.onClickClose()
      }
      R.id.btn_check -> {
        listener.onClickCheck()
      }
    }
  }
}