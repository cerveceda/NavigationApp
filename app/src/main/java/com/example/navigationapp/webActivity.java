package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class webActivity extends AppCompatActivity {

    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);
        et1 = (EditText)findViewById(R.id.etBusqueda);
    }

    public void Ir(View view) {
        Intent i = new Intent(this,activityWeb.class);
        i.putExtra("SitioWeb", et1.getText().toString());
        startActivity(i);
    }
}