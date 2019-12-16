package dev.chabowski.richnotes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Note> notes;

    public NoteListAdapter(Context context, ArrayList<Note> notes){
        this.context = context;
        this.notes = notes;
    }

    @Override
    public int getCount(){
        return notes.size();
    }

    @Override
    public Object getItem(int position){
        return notes.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.single_note, parent, false);
        }

        Note currentNote = (Note) getItem(position);

        LinearLayout wholeNote = (LinearLayout)convertView.findViewById(R.id.singleNote);
        TextView noteTitle = (TextView)convertView.findViewById(R.id.noteTitle);
        TextView noteText = (TextView)convertView.findViewById(R.id.noteText);

        noteTitle.setText(currentNote.title);
        noteText.setText(currentNote.text);

        int stroke;
        switch(currentNote.priority){
            case 0:
                stroke = R.drawable.stroke;
                break;
            case 1:
                stroke = R.drawable.stroke_priority_normal;
                break;
            case 2:
                stroke = R.drawable.stroke_priority_high;
                break;
            default:
                stroke = R.drawable.stroke;
        }

        wholeNote.setBackgroundResource(stroke);

        return convertView;
    }
}
