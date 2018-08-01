package com.color.note.util

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat

fun Context.toIcon(resId: Int): Drawable? = VectorDrawableCompat.create(this.resources, resId, null)

fun Context.toColoringIcon(resId: Int, color: Int): Drawable? = VectorDrawableCompat.create(this.resources, resId, null).also {
  it?.setTint(ContextCompat.getColor(this@toColoringIcon, color))
  it?.setTintMode(PorterDuff.Mode.SRC_IN)
}