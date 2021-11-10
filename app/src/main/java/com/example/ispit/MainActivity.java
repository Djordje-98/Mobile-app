
package com.example.ispit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String SHARED_PREFERENCES_PREFIX = "MainActivitySharedPreferencesPrefix";
    private final static String SHARED_PREFERENCES_KEY_NAME = "name";
    private final static String SHARED_PREFERENCES_KEY_EMAIL = "email";

    private EditText inputName;
    private EditText inputEmail;
    private Button buttonNext;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable((getResources().getColor(R.color.green))));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black));

        initComponents();
    }
    private void initComponents(){
        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.buttonNext:
                this.doRegistrujSe();
                break;
        }
    }

    private void doRegistrujSe(){
        String name = ((EditText)findViewById(R.id.inputName)).getText().toString();
        String email = ((EditText)findViewById(R.id.inputEmail)).getText().toString();

        if (name.isEmpty() || email.isEmpty()) {
            ((TextView) findViewById(R.id.labelPoruka)).setText("You didn't enter your email or name!");
        } else {
            if (name.matches("[A-Z][a-z]+") && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                Intent intent = new Intent(this, SuperHero.class);

                Bundle extra = new Bundle();

                extra.putString("name", ((EditText) findViewById(R.id.inputName)).getText().toString());
                intent.putExtras(extra);

                startActivity(intent);
            } else {
            ((TextView) findViewById(R.id.labelPoruka)).setText("Name or email is not in the correct format");
        }
        }
    }
    private void saveData(){
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();

            SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCES_PREFIX, 0);
            SharedPreferences.Editor editor = sp.edit();

            editor.putString(SHARED_PREFERENCES_KEY_NAME, name);
            editor.putString(SHARED_PREFERENCES_KEY_EMAIL, email);
            editor.commit();


    }
    private  void showData(){
        SharedPreferences sp = getSharedPreferences(SHARED_PREFERENCES_PREFIX, 0);
        String name = sp.getString(SHARED_PREFERENCES_KEY_NAME, "");
        String email = sp.getString(SHARED_PREFERENCES_KEY_EMAIL, "");

        inputName.setText(name);
        inputEmail.setText(email);
    }
}
