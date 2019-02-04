package labs.dadm.l0406_room.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactsDatabase extends RoomDatabase {

    private static ContactsDatabase contactsDatabase;

    public synchronized static ContactsDatabase getInstance(Context context) {
        if (contactsDatabase == null) {
            contactsDatabase = Room
                    .databaseBuilder(context, ContactsDatabase.class, "contact")
                    .allowMainThreadQueries()
                    .build();
        }
        return contactsDatabase;
    }

    public abstract ContactDao contactDao();

}
