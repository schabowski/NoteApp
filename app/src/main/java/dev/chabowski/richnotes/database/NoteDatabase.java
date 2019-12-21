package dev.chabowski.richnotes.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import dev.chabowski.richnotes.dao.NoteDAO;
import dev.chabowski.richnotes.models.Note;

@Database(entities = {Note.class}, version = 2, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDAO getNoteDAO();
}
