package com.example.musikfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView bpmtext;
    private Button taper;
    private Button reset;
    private double clicks=0;
    private long start;
    private long end;
    private double num;
    private String genre;
    private int res;
    String[] genres = {"None","Blues","Classical","Country","Electronic","Folk","Funk","Heavy metal","Hip hop","Jazz",
    "Latin","New age","Pop","Punk","R&B","Rap","Reggae","Rock","Soul","World"};

    public String getGenre() {
        return genre;
    }

    public int getRes() {
        return res;
    }

    public void gotoWebpart(View v)
    {
        Intent intent = new Intent(this, Finder.class);
        intent.putExtra("BPM",bpmtext.getText());
        intent.putExtra("Genre",genre);
        startActivity(intent);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bpmtext = findViewById(R.id.bpmtext);
        taper = findViewById(R.id.taper);
        reset = findViewById(R.id.reset);


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.spinner_item_text, genres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //genre = (String)adapterView.getItemAtPosition(i);
                String newgenre =(String)adapterView.getItemAtPosition(i);

                switch (newgenre)
                {
                    case "None":
                        newgenre = "";
                        break;
                    case "Blues":
                        newgenre = "-blues";
                        break;
                    case "Classical":
                        newgenre = "-classical";
                        break;
                    case "Country":
                        newgenre = "-country";
                        break;
                    case "Electronic":
                        newgenre = "-electronic";
                        break;
                    case "Folk":
                        newgenre = "-folk";
                        break;
                    case "Funk":
                        newgenre = "-funk";
                        break;
                    case "Heavy metal":
                        newgenre = "-heavy-metal";
                        break;
                    case "Hip hop":
                        newgenre = "-hip-hop";
                        break;
                    case "Jazz":
                        newgenre = "-jazz";
                        break;
                    case "Latin":
                        newgenre = "-latin";
                        break;
                    case "New age":
                        newgenre = "-new-age";
                        break;
                    case "Pop":
                        newgenre = "-pop";
                        break;
                    case "Punk":
                        newgenre = "-punk";
                        break;
                    case "R&B":
                        newgenre = "-rnb";
                        break;
                    case "Rap":
                        newgenre = "-rap";
                        break;
                    case "Reggae":
                        newgenre = "-reggae";
                        break;
                    case "Rock":
                        newgenre = "-rock";
                        break;
                    case "Soul":
                        newgenre = "-soul";
                        break;
                    case "World":
                        newgenre = "-world";
                        break;
                }
                genre=newgenre;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelected);


        taper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicks==0)
                {
                    start=System.currentTimeMillis();
                    clicks=1.0;
                }
                else
                {
                    end=System.currentTimeMillis();
                    clicks=clicks+1.0;
                    num=60.0/((end-start)/1000.0);
                    res= (int)((clicks-1)*num);
                    bpmtext.setText(String.valueOf(res));
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bpmtext.setText("0");
                clicks=0;
            }
        });
    }
}