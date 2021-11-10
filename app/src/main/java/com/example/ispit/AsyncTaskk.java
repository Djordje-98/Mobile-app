package com.example.ispit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class AsyncTaskk extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout mainScrollView;
    private TextView labelJson;
    private ImageView image;
    private Button buttonNext3;
    private TextView labelJsonName;

    private static final String URL = "https://www.superheroapi.com/api.php/10213942899445578/search/";



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_taskk);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable((getResources().getColor(R.color.green))));
        getWindow().setStatusBarColor(ContextCompat.getColor(AsyncTaskk.this, R.color.black));

      initComponents();
    }
    @SuppressLint("HandlerLeak")
    private void initComponents(){
        mainScrollView = findViewById(R.id.mainScrollView);
        labelJson = findViewById(R.id.labelJson);
        labelJsonName = findViewById(R.id.labelJsonName);
        buttonNext3 = findViewById(R.id.buttonNext3);
        buttonNext3.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");

        Api.getJSON(URL + name, new ReadDataHandler() {
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                String response = getJson();

                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("results");

                    TextView labelJson = findViewById(R.id.labelJson);
                    TextView labelJsonName = findViewById(R.id.labelJsonName);

                    LinkedList<PostModel> post = PostModel.parseJSONArray(array);
                    for (PostModel p : post) {
                        ImageView image = findViewById(R.id.image);
                        class ImageTask extends AsyncTask<String, Void, Bitmap> {

                            @Override
                            protected Bitmap doInBackground(String... strings) {
                                try{
                                    java.net.URL url = new java.net.URL(strings[0]);
                                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                                    con.setDoInput(true);
                                    con.connect();
                                    InputStream input = con.getInputStream();
                                    Bitmap bitmap = BitmapFactory.decodeStream(input);
                                    input.close();
                                    return bitmap;

                                } catch (Exception e) {

                                }
                                return null;
                            }

                            @Override
                            protected void onPostExecute(Bitmap result) {
                                image.setImageBitmap(result);

                            }
                        }
                        new ImageTask().execute(p.getImage());
                        ((TextView) findViewById(R.id.labelJsonName)).setText(p.getName());
                        ((TextView) findViewById(R.id.labelJsonPowerstats)).setText("Powerstats:");

                        labelJson.setText(
                                "Intelligence:" + " " + p.getIntelligence() + "\n" +
                                "Strength:" + " " + p.getStrength() + "\n" +
                                "Speed:" + " " + p.getSpeed() + "\n" +
                                "Durability:" + " " + p.getDurability() + "\n" +
                                "Power:" + " " + p.getPower() + "\n" +
                                "Combat:" + " " + p.getCombat());
                    }
                }
                catch (Exception e) {

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonNext3) {
            String name = labelJsonName.getText().toString();


            Bundle extras = new Bundle();
            extras.putString("name", name);

            startActivity(new Intent(this, AsyncTask2.class)
                    .putExtras(extras));
        }
    }

}
