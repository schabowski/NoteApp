package dev.chabowski.richnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String text = intent.getStringExtra("text");

        TextView titleTextView = findViewById(R.id.noteTitle);
        TextView textTextView = findViewById(R.id.noteText);

        titleTextView.setText(title);
        textTextView.setText(text);
    }
}
