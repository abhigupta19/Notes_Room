package com.sar.user.notes_room;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@android.arch.persistence.room.Database(entities = {Table.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract Object object();
    private static volatile Database database;
    static Database getDatabase(Context context)
    {
        if(database==null)
        {
            synchronized (Database.class)
            {
                if(database==null)
                {
                    database=Room.databaseBuilder(context.getApplicationContext(),Database.class,"note_database").build();
                }
            }
        }
   return database;
    }

}
