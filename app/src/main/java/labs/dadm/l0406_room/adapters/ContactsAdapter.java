package labs.dadm.l0406_room.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import labs.dadm.l0406_room.R;
import labs.dadm.l0406_room.databases.Contact;

public class ContactsAdapter extends ArrayAdapter {

    private int layout;

    public ContactsAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layout, null);
        }
        final Contact contact = (Contact) getItem(position);
        ((TextView) view.findViewById(R.id.tvName)).setText(contact.getName());
        ((TextView) view.findViewById(R.id.tvEmail)).setText(contact.getEmail());
        ((TextView) view.findViewById(R.id.tvPhone)).setText(contact.getPhone());
        return view;
    }
}
