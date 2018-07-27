package com.color.note.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
  @ColumnInfo(name = "name") val name: String,
  @ColumnInfo(name = "color") val color: Int
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int? = null
}