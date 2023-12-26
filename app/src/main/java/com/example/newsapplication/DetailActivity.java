package com.example.newsapplication;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webView = findViewById(R.id.webView);

        // Cấu hình WebView để hỗ trợ JavaScript và các tính năng khác nếu cần
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Nhận URL từ Intent và tải nó trong WebView
        String url = getIntent().getStringExtra("URL");
        if (url != null && !url.isEmpty()) {
            webView.loadUrl(url);
        } else {
            // Xử lý trường hợp URL không hợp lệ hoặc không có
            Toast.makeText(this, "No URL provided", Toast.LENGTH_LONG).show();
        }
    }
}
