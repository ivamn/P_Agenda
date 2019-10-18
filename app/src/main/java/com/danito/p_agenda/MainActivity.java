package com.danito.p_agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.danito.p_agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_contact);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                startActivity(i);
            }
        });

        EditText e1 = findViewById(R.id.nombre);
        EditText e2 = findViewById(R.id.apellidos);
        EditText e3 = findViewById(R.id.correo);
        EditText e4 = findViewById(R.id.phone);

        e1.setOnFocusChangeListener(this);
        e2.setOnFocusChangeListener(this);
        e3.setOnFocusChangeListener(this);
        e4.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        Drawable d = null;
        ImageView imageView = null;
        switch (v.getId()) {
            case R.id.nombre:
                imageView = findViewById(R.id.ico_nombre);
                d = imageView.getDrawable();
                break;
            case R.id.apellidos:
                imageView = findViewById(R.id.ico_apellidos);
                d = imageView.getDrawable();
                break;
            case R.id.phone:
                imageView = findViewById(R.id.ico_email);
                d = imageView.getDrawable();
                break;
            case R.id.correo:
                imageView = findViewById(R.id.ico_tlf);
                d = imageView.getDrawable();
                break;
        }
        d = DrawableCompat.wrap(d);
        if (hasFocus) {
            DrawableCompat.setTint(d, ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_primary));
        } else {
            DrawableCompat.setTint(d, ContextCompat.getColor(getApplicationContext(), R.color.colorIconos));
        }
    }
}