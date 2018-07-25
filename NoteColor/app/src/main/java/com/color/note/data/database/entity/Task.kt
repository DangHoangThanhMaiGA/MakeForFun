package com.color.note.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
  @ColumnInfo(name = "note_id") val noteId: Int,
  @ColumnInfo(name = "name") val name: String,
  @ColumnInfo(name = "date") val date: String,
  @ColumnInfo(name = "hour") val hour: String,
  @ColumnInfo(name = "status") val status: Int
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int? = null
}