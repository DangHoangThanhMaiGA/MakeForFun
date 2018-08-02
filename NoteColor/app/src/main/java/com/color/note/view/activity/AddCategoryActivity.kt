package com.color.note.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import com.afollestad.materialdialogs.MaterialDialog
import com.color.note.R
import com.color.note.util.Colors
import com.color.note.view.adapter.ColorAdapter
import com.color.note.view.component.Header
import com.color.note.view.component.Header.HeaderListener
import com.rengwuxian.materialedittext.MaterialEditText
import kotterknife.bindView

class AddCategoryActivity : BaseActivity(), OnItemClickListener, HeaderListener {

  private val gvColor by bindView<GridView>(R.id.gv_colors)
  private val txtName by bindView<MaterialEditText>(R.id.txt_name)
  private val header by bindView<Header>(R.id.header)
  private var chosenColorIndex: Int = -1

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_category)

    // prevent focus in edittext
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

    // header
    header.apply {
      txtTitle.text = getString(R.string.add_category_title)
      btnClose.setImageResource(R.drawable.close_gray)
    }
    header.setOnClickHeaderListener(this)

    // process grid color
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

  override fun onClickClose() {
    MaterialDialog.Builder(this)
        .title(R.string.title_confirm)
        .content(R.string.confirm_not_save_category)
        .positiveText(R.string.yes)
        .negativeText(R.string.no)
        .onPositive({ dialog, which ->
          finish()
        })
        .onNegative({ dialog, which ->
          dialog.dismiss()
        })
        .show()
  }

  override fun onClickCheck() {
    // TODO: Check validate of Name field check color -> Save data
    finish()
  }

  companion object {
    fun getIntent(context: Context): Intent = Intent(context, AddCategoryActivity::class.java)
  }
}
