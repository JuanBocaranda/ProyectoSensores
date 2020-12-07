package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

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
    RadioButton radiobutton1;
    RadioButton radiobutton2;
    RadioButton radiobutton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.rdgGrupo);
        radiobutton1 = findViewById(R.id.rdbOne);
        radiobutton2 = findViewById(R.id.rdbTwo);
        radiobutton3 = findViewById(R.id.rdbThree);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(), "Seleccione una Opción", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(radiobutton1.isChecked()){
                        Intent activity = new Intent(getApplicationContext(), Acelerometro.class);
                        startActivity(activity);
                    }
                    else if(radiobutton2.isChecked()){
                        Intent activity = new Intent(getApplicationContext(), Proximidad.class);
                        startActivity(activity);
                    }
                    else if(radiobutton3.isChecked()){
                        Intent activity = new Intent(getApplicationContext(), Gps.class);
                        startActivity(activity);
                    }
                }
            }
        });
    }
}