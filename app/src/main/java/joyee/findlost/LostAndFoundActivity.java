package joyee.findlost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;

public class LostAndFoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_and_found);

        Button btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(LostAndFoundActivity.this,DashboardActivity.class);
                startActivity(intent);

            }

        });


    }
}
