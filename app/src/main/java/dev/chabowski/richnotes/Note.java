package dev.chabowski.richnotes;

import java.util.Calendar;
import java.util.Date;

public class Note {
    Integer id;
    String title;
    String text;
    Integer priority = 0;
    Date creationDate = Calendar.getInstance().getTime();
    Date alarmDate = null;
    boolean isAlarmEnabled = false;
    boolean isSecret = false;
    boolean isPinned = false;

    public Note(Integer id, String title, String text){
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Note(Integer id, String title, String text, Integer priority, boolean isPinned){
        this.id = id;
        this.title = title;
        this.text = text;
        this.priority = priority;
        this.isPinned = isPinned;
    }

    public Note(Integer id, String title, String text, Integer priority, boolean isPinned, boolean isSecret){
        this.id = id;
        this.title = title;
        this.text = text;
        this.priority = priority;
        this.isPinned = isPinned;
        this.isSecret = isSecret;
    }

    public Note(Integer id, String title, String text, Integer priority, Date alarmDate, boolean isAlarmEnabled, boolean isPinned, boolean isSecret){
        this.id = id;
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
