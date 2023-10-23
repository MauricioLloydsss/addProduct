package com.example.addproduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AddActivity extends AppCompatActivity {

    EditText name,id,qty,turl;
    Button btnAdd, BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = (EditText)findViewById(R.id.name);
        id = (EditText)findViewById(R.id.id);
        qty = (EditText)findViewById(R.id.qty);
        turl = (EditText)findViewById(R.id.turl);

        btnAdd = (Button) findViewById(R.id.add);
        BtnBack = (Button) findViewById(R.id.back);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();


            }
        });

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });

    }

    private void insertData()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("id", id.getText().toString());
        map.put("qty", qty.getText().toString());
        map.put("turl", turl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("students").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted Successful", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "No data insert", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}