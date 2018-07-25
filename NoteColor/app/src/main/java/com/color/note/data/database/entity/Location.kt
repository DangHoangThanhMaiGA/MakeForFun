package com.color.note.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "locations")
data class Location(
  @ColumnInfo(name = "note_id") val noteId: Int,
  @ColumnInfo(name = "lat") val lat: Double,
  @ColumnInfo(name = "lon") val lon: Double,
  @ColumnInfo(name = "name") val name: String,
  @ColumnInfo(name = "address") val address: String
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int? = null
}