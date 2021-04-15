package com.androiddev.blogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class DetailedView extends AppCompatActivity {
        TextView name ;
        TextView date ;
        TextView title;
        TextView text;
        TextView tags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("POST");

        name = (TextView) findViewById(R.id.Name);
        title = (TextView) findViewById(R.id.titleView);
        text = (TextView) findViewById(R.id.textView);
        tags = (TextView) findViewById(R.id.tagsView);
        date = (TextView) findViewById(R.id.Date);

        Intent intent = getIntent();
        Posts post = PostsUsersDB.getPostsArrayList().get(Integer.parseInt(intent.getStringExtra("post")));

        name.setText(post.getAuthor());
        title.setText(post.getMainTitle());
        text.setText(post.getMainText());
        tags.setText(post.getTags());
        date.setText(post.getDate());

    }
}