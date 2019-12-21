package dev.chabowski.richnotes.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "notes")
public class Note implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public Integer id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "text")
    public String text;
    @ColumnInfo(name = "priority")
    public Integer priority = 0;
    @ColumnInfo(name = "is_pinned")
    @Nullable
    public boolean isPinned = false;
    @ColumnInfo(name = "creation_date")
    @Nullable
    public String creationDate = Calendar.getInstance().getTime().toString();
    @ColumnInfo(name = "alarm_date")
    @Nullable
    public String alarmDate = null;
    @ColumnInfo(name = "is_alarm_enabled")
    @Nullable
    public boolean isAlarmEnabled = false;
    @ColumnInfo(name = "is_secret")
    @Nullable
    public boolean isSecret = false;

    @Ignore
    public Note(){
        this.title = "null";
        this.text = "null";
    }
    @Ignore
    public Note(String title, String text){
        this.title = title;
        this.text = text;
    }

    @Ignore
    public Note(String title, String text, Integer priority, boolean isPinned){
        this.title = title;
        this.text = text;
        this.priority = priority;
        this.isPinned = isPinned;
    }

    public Note(String title, String text, Integer priority, boolean isPinned, boolean isSecret){
        this.title = title;
        this.text = text;
        this.priority = priority;
        this.isPinned = isPinned;
        this.isSecret = isSecret;
    }

    @Ignore
    public Note(String title, String text, Integer priority, String alarmDate, boolean isAlarmEnabled, boolean isPinned, boolean isSecret){
        this.title = title;
        this.text = text;
        this.priority = priority;
        this.isPinned = isPinned;
        this.alarmDate = alarmDate;
        if(alarmDate != null){
            this.isAlarmEnabled = isAlarmEnabled;
        }
        this.isSecret = isSecret;
    }
}
