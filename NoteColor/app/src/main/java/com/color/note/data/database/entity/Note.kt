package com.color.note.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
  @ColumnInfo(name = "name") val name: String,
  @ColumnInfo(name = "cate_id") val cateId: Int,
  @ColumnInfo(name = "created_date") val createdDate: String,
  @ColumnInfo(name = "text") val text: String
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int? = null
}