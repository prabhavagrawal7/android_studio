package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String msg = "com.example.multiscreen.MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ChangeActivity(View view){
        Intent intent = new Intent(this, activity2.class);
        String message = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
        intent.putExtra(msg, message);
        startActivity(intent);
    }
}