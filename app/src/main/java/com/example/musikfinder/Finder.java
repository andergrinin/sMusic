package com.example.musikfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Finder extends AppCompatActivity {
    private WebView viewer;
    private String url;
    private String BPM;
    private String genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finder);
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null)
        {
            genre = arguments.getString("Genre");
            BPM = arguments.getString("BPM");
        }
        url="https://getsongbpm.com/tempo/"+BPM+"-bpm"+genre;
        viewer = (WebView) findViewById(R.id.viewer);
        viewer.setWebViewClient(new WebViewClient());
        viewer.loadUrl(url);
    }
}