package com.example.ispit;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class
AsyncTask2 extends AppCompatActivity {

    private LinearLayout mainScrollView2;
    private TextView labelJson2;

    private static final String URL = "https://www.superheroapi.com/api.php/10213942899445578/search/";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task2);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable((getResources().getColor(R.color.green))));
        getWindow().setStatusBarColor(ContextCompat.getColor(AsyncTask2.this, R.color.black));

        initComponents();
    }

    @SuppressLint("HandlerLeak")
    private void initComponents() {
        mainScrollView2 = findViewById(R.id.mainScrollView2);
        labelJson2 = findViewById(R.id.labelJson2);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");

        Api.getJSON(URL + name, new ReadDataHandler(){
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                String response = getJson();

                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("results");

                    TextView labelJson2 = findViewById(R.id.labelJson2);
                    LinkedList<PostModel2> post = PostModel2.parseJSONArray(array);

                    for (PostModel2 p : post) {
                        labelJson2.setText("Full-name:" + " " + p.getFullName() + "\n\n" +
                                "Alter-ego:" + " " + p.getAlterEgo() + "\n\n" +
                                "Alias:" + " " + p.getAliases() + "\n\n" +
                                "First-appearance:" + " " + p.getFirstAppearance() + "\n\n" +
                                "Publisher:" + " " + p.getPublisher() + "\n\n" +
                                "Alignment:" + " " + p.getAligment() + "\n\n" +
                                "Gender:" + " " + p.getGender() + "\n\n" +
                                "Race:" + " " + p.getRace() + "\n\n" +
                                "Height:" + " " + p.getHeight() + "\n\n" +
                                "Weight:" + " " + p.getWeigth() + "\n\n" +
                                "Eye-color:" + " " + p.getEyeColor() + "\n\n" +
                                "Hair-color:" + " " + p.getHairColor());
                    }


                } catch (Exception e) {

                }
            }
        });
    }
}
