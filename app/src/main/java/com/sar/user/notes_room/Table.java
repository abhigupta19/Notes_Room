package com.sar.user.notes_room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")
public class Table {
    @PrimaryKey
    @NonNull
   public String id;

    public Table() {
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setNotes(@NonNull String notes) {
        this.notes = notes;
    }

    @NonNull
    @ColumnInfo(name = "note")
    public String notes;

    public Table( String id, String notes) {
        this.id = id;
        this.notes = notes;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getNotes() {
        return notes;
    }
}
