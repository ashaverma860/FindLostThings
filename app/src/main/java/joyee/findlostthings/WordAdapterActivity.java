package joyee.findlostthings;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapterActivity extends ArrayAdapter<Word> {


    public WordAdapterActivity(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_item, parent, false);
        }

        listItemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(v.getContext(),ItemDetails.class);
                v.getContext().startActivity(intent);

            }

        });

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        ImageView imageResourceId = (ImageView) listItemView.findViewById(R.id.image);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        imageResourceId.setImageResource(currentWord.getImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView ItemName = (TextView) listItemView.findViewById(R.id.itemname);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        ItemName.setText(currentWord.getItemname());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.


        return listItemView;


    }
}

