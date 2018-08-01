package com.color.note.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.EditText
import android.widget.GridView
import com.color.note.R
import com.color.note.util.Colors
import com.color.note.view.adapter.ColorAdapter
import kotterknife.bindView

class AddCategoryActivity : BaseActivity(), OnItemClickListener {

  private val gvColor by bindView<GridView>(R.id.gv_colors)
  private val txtName by bindView<EditText>(R.id.txt_name)
  private var chosenColorIndex: Int = -1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_category)


    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

    val colorList = Colors().getColors()
    var adapter = ColorAdapter(this)
    adapter.dataSource.addAll(colorList)

    gvColor.adapter = adapter
    gvColor.setOnItemClickListener(this)
  }

  override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    val adapter = gvColor.adapter
    if (adapter is ColorAdapter) {
      adapter.apply {
        dataSource.forEachIndexed { index, model ->
          model.isChecked = false
          if (index == position) {
            model.isChecked = true
            chosenColorIndex = position
          }
        }
        notifyDataSetChanged()
      }
    }
  }

  companion object {
    fun getIntent(context: Context): Intent = Intent(context, AddCategoryActivity::class.java)
  }
}
