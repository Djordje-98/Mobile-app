package com.example.ispit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;

public class SuperHero extends AppCompatActivity implements View.OnClickListener{

    private Button buttonNext2;
    private ListView labelListSuperHero;
    private AutoCompleteTextView inputAutoComplite;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_hero);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable((getResources().getColor(R.color.green))));
        getWindow().setStatusBarColor(ContextCompat.getColor(SuperHero.this, R.color.black));

        Bundle extra = getIntent().getExtras();

        String name = extra.getString("name");
        String message = "";
        message += "User" + " " + name + " " + "is logged in";
        ((TextView) findViewById(R.id.labelTitle2)).setText(message);

        search();
        initComponents();
    }

    @SuppressLint("WrongViewCast")
    private void search() {
        ListView labelListSuperHero;
        ArrayList<String> list;

        labelListSuperHero = findViewById(R.id.labelListSuperHero);


        list = new ArrayList<>();

        list.add("A-Bomb");list.add("Abe Sapien");list.add("Abin Sur");list.add("Abomination");
        list.add("Abraxas");list.add("Absorbing Man");list.add("Adam Monroe");list.add("Adam Strange");
        list.add("Agent 13");list.add("Agent Bob");list.add("Agent Zero");list.add("Air-Walker");
        list.add("Ajax");list.add("Alan Scott");list.add("Alex Mercer");list.add("Alex Woolsly");
        list.add("Alfred Pennyworth");list.add("Alien");list.add("Allan Quatermain");list.add("Amazo");
        list.add("Ammo");list.add("Ando Masahashi");list.add("Angel");list.add("Angel Dust");
        list.add("Angel Salvadore");list.add("Ando Masahashi");list.add("Angel");list.add("Angel Dust");
        list.add("Ammo");list.add("Angela");list.add("Animal Man");list.add("Annihilus");
        list.add("Ant-Man");list.add("Ant-Man II");list.add("Anti-Monitor");list.add("Anti-Spawn");
        list.add("Anti-Venom");list.add("Apocalypse");list.add("Aquababy");list.add("Aqualad");
        list.add("Aquaman");list.add("Arachne");list.add("Archangel");list.add("Arclight");
        list.add("Ardina");list.add("Ares");list.add("Ariel");list.add("Armor");
        list.add("Arsenal");list.add("Astro Boy");list.add("Atlas");list.add("Atom");
        list.add("Atom Girl");list.add("Atom II");list.add("Atom III");list.add("Atom IV");
        list.add("Aurora");list.add("Azazel");list.add("Azrael");list.add("Aztar");
        list.add("Bane");list.add("Banshee");list.add("Bantam");list.add("Batgirl");
        list.add("Batgirl III");list.add("Batgirl IV");list.add("Batgirl V");list.add("Batgirl VI");
        list.add("Batman");list.add("Batman II");list.add("Battlestar");list.add("Batwoman V");
        list.add("Beak");list.add("Beast");list.add("Beast Boy");list.add("Beetle");
        list.add("Ben 10");list.add("Beta Ray Bill");list.add("Beyonder");list.add("Big Barda");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, list);
        AutoCompleteTextView inputAutoComplite = findViewById(R.id.inputAutoComplite);
        inputAutoComplite.setThreshold(1);
        inputAutoComplite.setAdapter(adapter);
        labelListSuperHero.setAdapter(adapter);
        

    }

    private void initComponents() {
        inputAutoComplite = findViewById(R.id.inputAutoComplite);
        buttonNext2 = findViewById(R.id.buttonNext2);
        buttonNext2.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonNext2) {

            String name = inputAutoComplite.getText().toString();

            Bundle extras = new Bundle();
            extras.putString("name", name);

            startActivity(new Intent(SuperHero.this, AsyncTaskk.class)
                    .putExtras(extras));
        }
    }
}
