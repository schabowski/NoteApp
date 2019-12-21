package dev.chabowski.richnotes;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import dev.chabowski.richnotes.models.Note;

public class MainActivity extends AppCompatActivity {

    NoteRepository noteRepository;
    ListView listOfNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteRepository = new NoteRepository(getApplicationContext());

        final ArrayList<Note> notes = noteRepository.getAllNotes();
        NoteListAdapter adapter = new NoteListAdapter(this, notes);

        listOfNotes = findViewById(R.id.listOfNotes);
        listOfNotes.setAdapter(adapter);

        listOfNotes.setClickable(true);
        listOfNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = notes.get(position);
                showNote(note);
            }
        });

    }

    public void newNote(View view){
        Intent intent = new Intent(this, NewNoteActivity.class);
        startActivity(intent);
    }

    public void showNote(Note note){
        Bundle bundle = new Bundle();
        bundle.putSerializable("NOTE_TO_SHOW", note);
        Intent i = new Intent(this, NoteActivity.class);
        i.putExtras(bundle);
        startActivity(i);
    }
}
