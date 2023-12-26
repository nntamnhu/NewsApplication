package com.example.newsapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_NEWS_REQUEST_CODE = 100;
    private FloatingActionButton fabAdd;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List<News> newsItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd = findViewById(R.id.fab_add);
        recyclerView = findViewById(R.id.rv_news);
        newsItemList = new ArrayList<>();

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAdapter(this, newsItemList);
        recyclerView.setAdapter(adapter);

        // Set OnClickListener for FloatingActionButton
        fabAdd.setOnClickListener(view -> {
            Intent addNewsIntent = new Intent(MainActivity.this, AddNewsActivity.class);
            startActivityForResult(addNewsIntent, ADD_NEWS_REQUEST_CODE); // Sử dụng hằng số đã định nghĩa ở trên
        });

    }

    // Handle the result from AddNewsItemActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NEWS_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Retrieve the NewsItem from the intent
            News newNewsItem = (News) data.getSerializableExtra("NEW_NEWS_ITEM");
            // Add new item to your list and notify the adapter
            newsItemList.add(newNewsItem);
            adapter.notifyItemInserted(newsItemList.size() - 1);
        }
    }
}