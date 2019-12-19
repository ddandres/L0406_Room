/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0406_room.databases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/*
    Marks the class as an entity, which will map to a table in the database.
    Index will speed up SELECT but slow down INSERT and UPDATE.
    It must define getters and setters for all attributes.
 */
@Entity(indices = {@Index("name")})
public class Contact {

    // Autoincremental primary key
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_ID")
    private long id;

    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
