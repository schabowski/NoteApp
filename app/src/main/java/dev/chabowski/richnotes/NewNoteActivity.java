package dev.chabowski.richnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import dev.chabowski.richnotes.models.Note;

public class NewNoteActivity extends AppCompatActivity {

    Note note;

    boolean isItNewNote;

    EditText title;
    EditText text;

    NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        noteRepository = new NoteRepository(getApplicationContext());

        Intent intent = getIntent();

        title = findViewById(R.id.title);
        text = findViewById(R.id.text);


        if(intent.hasExtra("NOTE_TO_EDIT")){
            Bundle bundle = intent.getExtras();
            note = (Note)bundle.getSerializable("NOTE_TO_EDIT");
            title.setText(note.title);
            text.setText(note.text);

            isItNewNote = false;
        }else{
            note = new Note();
            isItNewNote = true;
        }
    }

    public void extraSettings (View view){
        setUpdatedValues();

        if(isItNewNote){
            insertNote();
        }

        Bundle noteToSetSettings = new Bundle();
        noteToSetSettings.putSerializable("NOTE_TO_SET_SETTINGS", note);

        Intent noteSettingsIntent = new Intent(this, NewNoteConfigActivity.class);
        noteSettingsIntent.putExtras(noteToSetSettings);

        startActivity(noteSettingsIntent);
    }

    public void saveNote (View view){
        setUpdatedValues();

        if(isItNewNote){
            insertNote();
        }else{
            updateNote();
        }

        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

    private void setUpdatedValues(){
        note.title = title.getText().toString();
        note.text = text.getText().toString();
    }

    private void insertNote(){
        noteRepository.insertNote(note);
    }
    private void updateNote(){
        noteRepository.updateNote(note);
    }


}
