package dev.chabowski.richnotes;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.ArrayList;

import dev.chabowski.richnotes.database.NoteDatabase;
import dev.chabowski.richnotes.models.Note;

public class NoteRepository {
    private String DB_NAME = "notes";

    private NoteDatabase noteDatabase;
    public NoteRepository(Context context){
        noteDatabase = Room.databaseBuilder(context, NoteDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    public void insertNote(final Note note) {
        noteDatabase.getNoteDAO().insert(note);
    }

    public ArrayList<Note> getAllNotes(){
        return new ArrayList<>(noteDatabase.getNoteDAO().getAllNotes());
    }

    public void updateNote(final Note note){
        noteDatabase.getNoteDAO().update(note);
    }
}
