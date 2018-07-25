package com.color.note.enum

import com.color.note.R

enum class Theme(val id: Int,
  val mainColor: Int,
  val subColor: Int,
  val backGroundColor: Int,
  val sectionColorStart: Int,
  val sectionColorEnd: Int,
  val sectionTextColor: Int,
  val textColor: Int) {
  DEFAULT(1,
      R.color.default_style_main_color,
      R.color.default_style_sub_color,
      R.color.default_style_background,
      R.color.default_style_section_start,
      R.color.default_style_section_end,
      R.color.default_style_section_text,
      R.color.default_style_text)
}