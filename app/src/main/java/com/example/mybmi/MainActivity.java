package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        String FileName = "myFile";
        EditText name;
        EditText weight;
        EditText height;
        Button go;
        TextView display;
        String output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        weight= findViewById(R.id.weight);
        height= findViewById(R.id.height);
        go= findViewById(R.id.go);
        display= findViewById(R.id.display);
        SharedPreferences sharedPref = getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String defaultValue = "DefaultName";
        String output = sharedPref.getString("name", defaultValue);
        display.setText(output);

    }

    public void btngo(View view) {
        String textname;
        textname = name.getText().toString();
        String strkilo = weight.getText().toString();
        double dataweight = Double.parseDouble(strkilo);
        String strheight = height.getText().toString();
        double dataheight = Double.parseDouble(strheight);
        double bmi = (dataweight)/(dataheight*dataheight);
        SharedPreferences sharedPref = getSharedPreferences(FileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name","Name: "+textname +"\nBMI: "+ bmi );
        editor.commit();
        display.setText("Name: "+textname +"\nBMI: "+ bmi);
    }




}
