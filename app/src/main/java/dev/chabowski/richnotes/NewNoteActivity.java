package dev.chabowski.richnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
    }

    public void extraSetting(View view){
        Intent intent = new Intent(this, NewNoteActivity.class);
        EditText title = findViewById(R.id.title);
        EditText text = findViewById(R.id.text);
        intent.putExtra("title", title.getText());
        intent.putExtra("text", text.getText());
        startActivity(intent);
    }
}
