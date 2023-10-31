package com.example.exercise3;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;

public class Event implements Parcelable {
    private int id;
    private String subject;
    private String room;
    private String date;
    private boolean enable;

    public Event(String subject, String room, String date) {
        this.subject = subject;
        this.room = room;
        this.date = date;
        this.enable = true;
    }

    public Event(int id, String subject, String room, String date, boolean enable) {
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.date = date;
        this.enable = enable;
    }

    public Event() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    // Parcelable
    @RequiresApi(api = Build.VERSION_CODES.Q) // dùng khi có kiểu dữ liệu boolean
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(subject);
        dest.writeString(room);
        dest.writeString(date);
        dest.writeBoolean(enable);
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Event(Parcel source) {
        subject = source.readString();
        room = source.readString();
        date = source.readString();
        enable = source.readBoolean();
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
