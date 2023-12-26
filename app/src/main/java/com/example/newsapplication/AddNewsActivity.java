package com.example.newsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewsActivity extends AppCompatActivity {

    private EditText edtTilte, edtImageURL, edtURL;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_news);

        edtTilte = findViewById(R.id.edtTitle);
        edtImageURL = findViewById(R.id.edtImageURL);
        edtURL = findViewById(R.id.edtURL);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(view -> {
            // Create a new NewsItem from user input
            String title = edtTilte.getText().toString().trim();
            String imageUrl = edtImageURL.getText().toString().trim();
            String contentUrl = edtURL.getText().toString().trim();

            News newsItem = new News(imageUrl, title, contentUrl);

            // Return the result to MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("NEW_NEWS_ITEM", newsItem);
            setResult(RESULT_OK, resultIntent);
            finish(); // Close the activity
        });
    }
}
