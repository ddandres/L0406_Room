/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0406_room.databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
    Defines the operation to access the database.
 */
@Dao
public interface ContactDao {

    /*
        Returns a list with all Contacts.
     */
    @Query("SELECT * FROM contact")
    List<Contact> getContacts();

    /*
        Inserts a new Contact or replace an existing one if their primary keys match.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addContact(Contact contact);

    /*
        Updates a Contact with new information.
     */
    @Update
    void updateContact(Contact contact);

    /*
        Removes a Contact (identified by its primary key).
     */
    @Delete
    void deleteContact(Contact contact);
}
