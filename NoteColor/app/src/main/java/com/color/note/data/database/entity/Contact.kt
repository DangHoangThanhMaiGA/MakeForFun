package com.color.note.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
  @ColumnInfo(name = "note_id") val noteId: Int,
  @ColumnInfo(name = "name") val name: String,
  @ColumnInfo(name = "phone") val phone: String
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int? = null
}