package joyee.findlostthings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordlist);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("purse",R.drawable.purses));
        words.add(new Word("watch",R.drawable.watchs ));
        words.add(new Word("Ring",R.drawable.ring));
        WordAdapterActivity adapter = new WordAdapterActivity(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        Button btn_additem = (Button)findViewById(R.id.btn_additem);
        btn_additem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(ItemsActivity.this,AddItemActivity.class);
                startActivity(intent);

            }

        });
    }
}