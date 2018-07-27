package com.color.note.data.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "profile")
data class Profile(
  @ColumnInfo(name = "name") val name: String,
  @ColumnInfo(name = "avatar_url") val avatarUrl: String
)