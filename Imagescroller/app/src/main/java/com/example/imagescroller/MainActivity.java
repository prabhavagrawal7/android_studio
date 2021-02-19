package com.example.imagescroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void sendNow(View view) {


        Toast.makeText(this, "This is sending data from app...", Toast.LENGTH_SHORT).show();


    }


    public void receiveNow(View view) {
        Toast.makeText(this, "This is receiving data from app...", Toast.LENGTH_SHORT).show();

    }

    public void deleteNow(View view) {
        Toast.makeText(this, "This is deleting data from app...", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
