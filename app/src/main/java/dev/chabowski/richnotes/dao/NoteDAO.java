package dev.chabowski.richnotes.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import dev.chabowski.richnotes.models.Note;

@Dao
public interface NoteDAO {
    @Insert
    public void insert(Note note);
    @Update
    public void update(Note note);
    @Delete
    public void delete(Note note);
    @Query("SELECT * FROM notes ORDER BY is_pinned DESC")
    List<Note> getAllNotes();
    @Query("SELECT * FROM notes WHERE id LIKE :id LIMIT 1")
    Note findNoteById(int id);
}
