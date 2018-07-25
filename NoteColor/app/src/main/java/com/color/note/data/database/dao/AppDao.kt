package com.color.note.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.color.note.data.database.entity.Category
import com.color.note.data.database.entity.Contact
import com.color.note.data.database.entity.Location
import com.color.note.data.database.entity.Note
import com.color.note.data.database.entity.Photo
import com.color.note.data.database.entity.Task

@Dao
interface AppDao {

  /**
   * Categories
   */
  @Query("SELECT * FROM categories")
  fun getCategories(): List<Category>

  @Insert(onConflict = REPLACE)
  fun insertCategories(category: Category)

  @Update(onConflict = REPLACE)
  fun updateCategories(category: Category)

  @Query("DELETE FROM categories WHERE id = :id")
  fun deleteCategories(id: Int)

  /**
   * Notes
   */
  @Query("SELECT * FROM notes")
  fun getNotes(): List<Note>

  @Query("SELECT * FROM notes WHERE cate_id = :cateId")
  fun getNotesByCateId(cateId: Int)

  @Insert(onConflict = REPLACE)
  fun insertNote(note: Note)

  @Update(onConflict = REPLACE)
  fun updateNote(note: Note)

  @Query("DELETE FROM notes WHERE id = :id")
  fun deleteNote(id: Int)

  /**
   * Locations
   */
  @Query("SELECT * FROM locations")
  fun getLocations(): List<Location>

  @Query("SELECT * FROM locations WHERE note_id = :noteId")
  fun getNotesByNoteId(noteId: Int)

  @Insert(onConflict = REPLACE)
  fun insertLocation(location: Location)

  @Query("UPDATE locations SET name = :name, address = :address WHERE id = :id")
  fun updateLocations(id: Int, name: String, address: String)

  @Query("DELETE FROM locations WHERE id = :id")
  fun deleteLocations(id: Int)

  @Query("DELETE FROM locations WHERE note_id = :noteId")
  fun deleteLocationsByNoteId(noteId: Int)

  /**
   * Contacts
   */
  @Query("SELECT * FROM contacts")
  fun getContacts(): List<Contact>

  @Query("SELECT * FROM contacts WHERE note_id = :noteId")
  fun getContactsByNoteId(noteId: Int)

  @Insert(onConflict = REPLACE)
  fun insertContact(contact: Contact)

  @Query("UPDATE contacts SET name = :name, phone = :phone WHERE id = :id")
  fun updateContacts(id: Int, name: String, phone: String)

  @Query("DELETE FROM contacts WHERE id = :id")
  fun deleteContacts(id: Int)

  @Query("DELETE FROM contacts WHERE note_id = :noteId")
  fun deleteContactsByNoteId(noteId: Int)

  /**
   * Tasks
   */
  @Query("SELECT * FROM tasks")
  fun getTasks(): List<Task>

  @Query("SELECT * FROM tasks WHERE note_id = :noteId")
  fun getTasksByNoteId(noteId: Int)

  @Query("SELECT * FROM tasks WHERE status = :status")
  fun getTasksByStatus(status: Int)

  @Insert(onConflict = REPLACE)
  fun insertTask(task: Task)

  @Query("UPDATE tasks SET name = :name WHERE id = :id")
  fun updateTasksName(id: Int, name: String)

  @Query("UPDATE tasks SET status = :status WHERE id = :id")
  fun updateTasksStatus(id: Int, status: Int)

  @Query("DELETE FROM tasks WHERE id = :id")
  fun deleteTasks(id: Int)

  @Query("DELETE FROM tasks WHERE note_id = :noteId")
  fun deleteTasksByNoteId(noteId: Int)

  /**
   * Photo
   */
  @Query("SELECT * FROM photos")
  fun getPhotos(): List<Photo>

  @Query("SELECT * FROM photos WHERE note_id = :noteId")
  fun getPhotosByNoteId(noteId: Int)

  @Insert(onConflict = REPLACE)
  fun insertPhoto(photo: Photo)

  @Query("DELETE FROM photos WHERE id = :id")
  fun deletePhoto(id: Int)

  @Query("DELETE FROM photos WHERE note_id = :noteId")
  fun deletePhotosByNoteId(noteId: Int)

}