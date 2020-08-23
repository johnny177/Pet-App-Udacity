package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.pet_list, viewGroup, false);
        return view ;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //find the fields to populate in the inflated template
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.summary);

        String name = cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_NAME));

        String breed = cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_BREED));

        // If the pet breed is empty string or null, then use some default text
        // that says "Unknown breed", so the TextView isn't blank.
        if (TextUtils.isEmpty(breed)) {
            breed = context.getString(R.string.unknown_breed);
        }
        nameTextView.setText(name);
        summaryTextView.setText(breed);

    }
}
