package dev.chabowski.richnotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Note note = new Note(0, "Notatka testowa", "1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n", 0, false);
        Note note1 = new Note(1, "Notatka testowa2", "asdasdasdas", 1, false);
        Note note2 = new Note(2, "Notatka testowa2", "asdasdasdas", 0, true);
        Note note3 = new Note(3, "Notatka testowa2", "asdasdasdas", 2, false);

        final ArrayList<Note> notes = new ArrayList<>();
        notes.add(note);
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);

        NoteListAdapter adapter = new NoteListAdapter(this, notes);

        final ListView listOfNotes = findViewById(R.id.listOfNotes);
        listOfNotes.setAdapter(adapter);

        listOfNotes.setClickable(true);
        listOfNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = notes.get(position); //TODO remember about database query
                showNote(note);
            }
        });
    }

    public void newNote(View view){
        Intent intent = new Intent(this, NewNoteActivity.class);
        startActivity(intent);
    }

    public void editNote(){
        Intent i = new Intent(this, EditNoteActivity.class);
        i.putExtra("id", 0); //TODO change to real id etc
    }

    public void showNote(Note note){
        Intent i = new Intent(this, NoteActivity.class);
        i.putExtra("id", note.id);
        i.putExtra("title", note.title);
        i.putExtra("text", note.text);
        i.putExtra("priority", note.priority);
        i.putExtra("isPinned", note.isPinned);
        startActivity(i);
    }
}
