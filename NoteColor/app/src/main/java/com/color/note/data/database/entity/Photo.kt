package com.color.note.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(
  @ColumnInfo(name = "note_id") val noteId: Int,
  @ColumnInfo(name = "path") val path: String
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int? = null
}