/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0406_room.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Provides access to the database thorugh the associated DAO.
// It implements a Singleton pattern so just one instance of this class exists at any time.
// It can prevent schema from being exported by setting exportSchema = false.
@Database(entities = {Contact.class}, version = 1)
public abstract class ContactsDatabase extends RoomDatabase {

    // Singleton pattern to centralize access to the database
    private static ContactsDatabase contactsDatabase;

    public synchronized static ContactsDatabase getInstance(Context context) {
        if (contactsDatabase == null) {
            contactsDatabase = Room
                    .databaseBuilder(context, ContactsDatabase.class, "contact")
                    .allowMainThreadQueries() // THIS CAN ONLY BE USED FOR TESTING
                    .build();
        }
        return contactsDatabase;
    }

    // DAO to access database operations
    public abstract ContactDao contactDao();
}
