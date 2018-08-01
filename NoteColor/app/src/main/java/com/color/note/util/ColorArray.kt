package com.color.note.util

import com.color.note.R

class Colors {
  val colorArrayList = ArrayList<Color>()

  init {
    colorArrayList.add(Color(R.color.red1))
    colorArrayList.add(Color(R.color.red2))
    colorArrayList.add(Color(R.color.red3))
    colorArrayList.add(Color(R.color.red4))
    colorArrayList.add(Color(R.color.red5))
    colorArrayList.add(Color(R.color.violet1))
    colorArrayList.add(Color(R.color.violet2))
    colorArrayList.add(Color(R.color.violet3))
    colorArrayList.add(Color(R.color.violet4))
    colorArrayList.add(Color(R.color.violet5))
    colorArrayList.add(Color(R.color.blue1))
    colorArrayList.add(Color(R.color.blue2))
    colorArrayList.add(Color(R.color.blue3))
    colorArrayList.add(Color(R.color.blue4))
    colorArrayList.add(Color(R.color.blue5))
    colorArrayList.add(Color(R.color.green1))
    colorArrayList.add(Color(R.color.green2))
    colorArrayList.add(Color(R.color.green3))
    colorArrayList.add(Color(R.color.green4))
    colorArrayList.add(Color(R.color.green5))
    colorArrayList.add(Color(R.color.yellow1))
    colorArrayList.add(Color(R.color.yellow2))
    colorArrayList.add(Color(R.color.yellow3))
    colorArrayList.add(Color(R.color.yellow4))
    colorArrayList.add(Color(R.color.yellow5))
  }

  fun getColors() : ArrayList<Color> = colorArrayList
}

class Color(val color: Int, var isChecked: Boolean = false)