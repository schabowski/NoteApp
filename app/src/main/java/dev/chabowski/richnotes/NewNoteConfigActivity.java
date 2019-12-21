package dev.chabowski.richnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;

import dev.chabowski.richnotes.models.Note;

public class NewNoteConfigActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    NoteRepository noteRepository;

    Note note;

    Spinner prioritySpinner;
    //final String[] spinnerValues = {getResources().getString(R.string.low), getResources().getString(R.string.normal), getResources().getString(R.string.high)};
    final String[] spinnerValues = {"Niski", "Normalny", "Wysoki"};

    Switch isPinned;
    Switch isSecret;

    Integer priority = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note_config);

        noteRepository = new NoteRepository(getApplicationContext());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        note = (Note)bundle.getSerializable("NOTE_TO_SET_SETTINGS");

        prioritySpinner = findViewById(R.id.spinner);
        isPinned = findViewById(R.id.isPinned);
        isSecret = findViewById(R.id.isSecret);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues);
        prioritySpinner.setAdapter(adapter);
        prioritySpinner.setOnItemSelectedListener(this);
    }

    public void saveNoteSettings(View view){
        note.isPinned = isPinned.isChecked();
        Log.d("IS PINNED", String.valueOf(isPinned.isChecked()));
        note.isSecret = isSecret.isChecked();
        note.priority = priority;

        noteRepository.updateNote(note);

        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        priority = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        priority = 0;
    }
}
