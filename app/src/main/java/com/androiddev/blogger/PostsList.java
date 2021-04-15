package com.androiddev.blogger;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class PostsList extends AppCompatActivity implements View.OnClickListener {
        Button newPost ;
        ListView listView;
        TextView name ;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_list);
        getSupportActionBar().setTitle("FEED");


        name = (TextView) findViewById(R.id.nameOfUser);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("position"));

        listView = (ListView) findViewById(R.id.listView);
        Date currentTime = Calendar.getInstance().getTime();

        PostsAdapter adapter = new PostsAdapter(PostsList.this,R.layout.list_constructor,PostsUsersDB.getPostsArrayList());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        newPost = (Button) findViewById(R.id.AddingButton);
        newPost.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.AddingButton:
                Intent intent = new Intent(PostsList.this,NewPost.class);
                startActivity(intent);
                break;

        }
    }
}