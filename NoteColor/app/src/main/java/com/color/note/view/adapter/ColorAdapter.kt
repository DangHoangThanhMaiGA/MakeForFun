package com.color.note.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.color.note.R
import com.color.note.util.Color
import com.color.note.util.toColoringIcon

class ColorAdapter(val context: Context) : BaseAdapter() {
  var dataSource = ArrayList<Color>()

  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      val view: View
      val holder: ColorViewHolder
      if (convertView == null) {
        view = LayoutInflater.from(context).inflate(R.layout.view_item_color, parent, false)
        holder = ColorViewHolder(view)
        view.tag = holder
      } else {
        view = convertView
        holder = view.tag as ColorViewHolder
      }
      holder.colorDot.setImageDrawable(context.toColoringIcon(R.drawable.item_color, dataSource[position].color))
      holder.check.visibility = View.GONE
      if (dataSource[position].isChecked) {
        holder.check.visibility = View.VISIBLE
      }
    return view
  }

  override fun getItem(position: Int): Color = dataSource[position]

  override fun getItemId(position: Int): Long = position.toLong()

  override fun getCount(): Int = dataSource.size

  inner class ColorViewHolder(view: View?) {
    val colorDot: ImageView
    val check: ImageView
    init {
      colorDot = view?.findViewById(R.id.color_dot) as ImageView
      check = view.findViewById(R.id.check) as ImageView
    }
  }
}