package labs.sdm.l0406_room.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import labs.sdm.l0406_room.R;
import labs.sdm.l0406_room.databases.Contact;

public class ContactsAdapter extends ArrayAdapter {

    List<Contact> list;
    Context context;
    int layout;

    public ContactsAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layout, null);
        }
        ((TextView) view.findViewById(R.id.tvName)).setText(this.list.get(position).getName());
        ((TextView) view.findViewById(R.id.tvEmail)).setText(this.list.get(position).getEmail());
        ((TextView) view.findViewById(R.id.tvPhone)).setText(this.list.get(position).getPhone());
        return view;
    }
}
