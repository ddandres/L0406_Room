/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0406_room.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import labs.dadm.l0406_room.R;
import labs.dadm.l0406_room.databases.Contact;

public class ContactsAdapter extends ArrayAdapter<Contact> {

    // Hold reference to the layout
    private final int layout;

    // Hold references to View elements
    private static class ContactHolder {
        TextView tvName;
        TextView tvEmail;
        TextView tvPhone;
    }

    public ContactsAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.layout = resource;
    }

    // Creates and populates a View with the information from the required position of the data source.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View result = convertView;
        ContactHolder holder;

        // Reuse the View if it already exists
        if (result == null) {
            // Inflate the View to create it for the first time
            result = LayoutInflater.from(getContext()).inflate(layout, null);

            // Keep references for View elements in the layout
            holder = new ContactHolder();
            holder.tvName = result.findViewById(R.id.tvName);
            holder.tvEmail = result.findViewById(R.id.tvEmail);
            holder.tvPhone = result.findViewById(R.id.tvPhone);
            // Associate the ViewHolder to the View
            result.setTag(holder);
        }

        final Contact contact = (Contact) getItem(position);
        if (contact != null) {
            // Retrieve the ViewHolder from the View
            holder = (ContactHolder) result.getTag();
            // Populate the View with information from the required position of the data source
            holder.tvName.setText(contact.getName());
            holder.tvEmail.setText(contact.getEmail());
            holder.tvPhone.setText(contact.getPhone());
        }

        // Return the View
        return result;
    }
}
