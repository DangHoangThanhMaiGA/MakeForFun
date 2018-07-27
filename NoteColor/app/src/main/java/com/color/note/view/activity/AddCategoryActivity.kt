package com.color.note.view.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.color.note.R

class AddCategoryActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_category)
  }

  companion object {
    fun getIntent(context: Context): Intent = Intent(context, AddCategoryActivity::class.java)
  }
}
