package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    RadioGroup radioGroup;
    RadioButton radiobutton;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.rdgGrupo);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int selectedID = radioGroup.getCheckedRadioButtonId();
                radiobutton = findViewById(selectedID);
                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(), "Seleccione una Opción", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(radiobutton.getText() == "Acelerometro"){
                        Intent activity = new Intent(getApplicationContext(), Acelerometro.class);
                        startActivity(activity);
                    }
                    else if(radiobutton.getText() == "Huella"){
                        Intent activity = new Intent(getApplicationContext(), Huella.class);
                        startActivity(activity);
                    }
                    else if(radiobutton.getText() == "GPS"){
                        Intent activity = new Intent(getApplicationContext(), Gps.class);
                        startActivity(activity);
                    }
                }
            }
        });
    }
}