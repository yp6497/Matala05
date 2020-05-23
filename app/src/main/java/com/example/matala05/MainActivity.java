package com.example.matala05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    WebView wv;
    String s1, s2, s3, url;
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView) findViewById(R.id.wv);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView ww, String url) {
            ww.loadUrl(url);
            return true;
        }
    }

    public void go(View view) {
        s1 = ed1.getText().toString();
        s2 = ed2.getText().toString();
        s3 = ed3.getText().toString();
        if (s1.isEmpty() || (s1.equals(".") || s2.equals(".") || s3.equals(".")) || (s1.equals("-") || s2.equals("-") || s3.equals("-")) || (s1.equals("-.") || s2.equals("-.") || s3.equals("-."))||s1=="0") {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        } else {
            if (s2.isEmpty()) {
                if (s3.charAt(0) == '-')
                    url = "https://www.google.com/search?q=" + s1 + "x%5E2" + s3;
                else url = "https://www.google.com/search?q=" + s1 + "x%5E2%2B" + s3;
            }
            if (s3.isEmpty()) {
                if (s2.charAt(0) == '-')
                    url = "https://www.google.com/search?q=" + s1 + "x%5E2" + s2 + "x";
                else url = "https://www.google.com/search?q=" + s1 + "x%5E2%2B" + s2 + "x";
            }
             if (s2.isEmpty() && s3.isEmpty()) {
                 url = "https://www.google.com/search?q=" + s1 + "x%5E2";
             }
            if (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
                url = "https://www.google.com/search?q=" + s1 + "x%5E2%2B" + s2 + "x%2B" + s3;
                if (s2.charAt(0) == '-')
                    url = "https://www.google.com/search?q=" + s1 + "x%5E2" + s2 + "x%2B" + s3;
                if (s3.charAt(0) == '-')
                    url = "https://www.google.com/search?q=" + s1 + "x%5E2%2B" + s2 + "x" + s3;
                if (s2.charAt(0) == '-' && s3.charAt(0) == '-')
                    url = "https://www.google.com/search?q=" + s1 + "x%5E2" + s2 + "x" + s3;
            }
            wv.loadUrl(url);
        }
    }
}










