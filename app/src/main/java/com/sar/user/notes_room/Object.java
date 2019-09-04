package com.sar.user.notes_room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.util.Log;

@Dao
public interface Object {

    @Insert
    public void insert(Table table);


}
