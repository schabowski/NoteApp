package dev.chabowski.richnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import dev.chabowski.richnotes.databinding.ActivityNoteBinding;
import dev.chabowski.richnotes.models.Note;

public class NoteActivity extends AppCompatActivity {

    ActivityNoteBinding binding;
    boolean isRotate = false;

    TextView titleTextView;
    TextView textTextView;

    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        note = (Note)bundle.getSerializable("NOTE_TO_SHOW");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_note);

        FabAnimation.init(binding.fabSetAlarm);
        FabAnimation.init(binding.fabEditNote);

        binding.fabMoreOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRotate = FabAnimation.rotateFab(view, !isRotate);
                if(isRotate){
                    FabAnimation.showIn(binding.fabEditNote);
                    FabAnimation.showIn(binding.fabSetAlarm);
                }else{
                    FabAnimation.showOut(binding.fabEditNote);
                    FabAnimation.showOut(binding.fabSetAlarm);
                }
            }
        });

        titleTextView = findViewById(R.id.noteTitle);
        textTextView = findViewById(R.id.noteText);

        titleTextView.setText(note.title);
        textTextView.setText(note.text);
    }

    public void editNote(View view){
        Bundle bundle = new Bundle();
        bundle.putSerializable("NOTE_TO_EDIT", note);

        Intent intent = new Intent(this, NewNoteActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
