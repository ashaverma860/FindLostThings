package joyee.findlostthings;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import static android.R.attr.data;
import static joyee.findlostthings.R.id.btn_camera;
import static joyee.findlostthings.R.id.btn_save;

public class AddItemActivity extends AppCompatActivity {
    private static final int RC_IMAGE = 2;
    private ImageView imageView;
    private FirebaseStorage mDatabaseStorage;
    private StorageReference mStorageReference;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    EditText ItemName;
    EditText ItemLocation;
    EditText ItemDiscription;
    EditText Date;
    EditText Time;
    ImageView ImageUrl;
    Button btn_save;
    Uri downloadUrl;
    String imageEncoded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("details");
        mDatabaseStorage = FirebaseStorage.getInstance();
        mStorageReference = mDatabaseStorage.getReference();
        imageView = (ImageView) findViewById(R.id.image);
        ItemName = (EditText) findViewById(R.id.et_itemname);
        ItemLocation = (EditText) findViewById(R.id.et_location);
        ItemDiscription = (EditText) findViewById(R.id.et_itemdisc);
        Date = (EditText) findViewById(R.id.et_date);
        Time = (EditText) findViewById(R.id.et_time);


        Button btn_camera = (Button) findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, RC_IMAGE);
            }
        });

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                User users = new User(ItemName.getText().toString(), ItemLocation.getText().toString(), ItemDiscription.getText().toString(), Date.getText().toString(), Time.getText().toString(), downloadUrl.toString());
                mDatabaseReference.push().setValue(users);
            }


        });

    }


    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);

        Uri uri = data.getData();
        StorageReference filepath = mStorageReference.child("photos").child(uri.getLastPathSegment());

        filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // Get a URL to the uploaded content
                Uri downloadUrl = taskSnapshot.getDownloadUrl();

            }


        });
    }

    }






