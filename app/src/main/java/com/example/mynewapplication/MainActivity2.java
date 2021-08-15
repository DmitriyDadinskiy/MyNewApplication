package com.example.mynewapplication;

import static com.example.mynewapplication.R.style.MyCoolButtons;
import static com.example.mynewapplication.R.style.Theme_MyNewApplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity2 extends AppCompatActivity {

    private static final String NameSharedPreference = "LOGIN";
    static String appTheme = "APP_THEME";
    private static final int difTheme = 0;
    private static final int MyCoolButton = 1;


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getTheme(Theme_MyNewApplication));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initTheme();
        Button exit = findViewById(R.id.button_exit);
        exit.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity2.this, MainActivity.class);
            i.putExtra("APP_THEME", appTheme);//пытаюсь сохранить выбранную тему и передать ее в активити
            finish();
        });
    }

    private void initTheme() {
        initRadioButton(findViewById(R.id.radioButton), difTheme);
        initRadioButton(findViewById(R.id.MyCoolButton), MyCoolButton);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(difTheme))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity2.this.setAppTheme(codeStyle);
                recreate();
            }
        });

    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(appTheme, codeStyle);
    }

    private int getTheme(int codeStyle) {
        return Style(getCodeStyle(codeStyle));
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme, codeStyle);
        editor.apply();
    }

    private int Style(int codeStyle) {
        switch (codeStyle) {
            case MyCoolButton:
                return MyCoolButtons;
            default:
                return Theme_MyNewApplication;
        }
    }

}