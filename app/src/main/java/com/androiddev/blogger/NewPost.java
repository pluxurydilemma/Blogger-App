package com.androiddev.blogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewPost extends AppCompatActivity {
        EditText title ;
        EditText tags ;
        EditText text;
        Button create ;
        EditText author;
        ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);



        title = (EditText) findViewById(R.id.TitleOfNewPost);
        tags = (EditText) findViewById(R.id.tags);
        text = (EditText) findViewById(R.id.textOfNewPost);
        create = (Button) findViewById(R.id.buttonCreate);
        author = (EditText) findViewById(R.id.nameOfAuthor);
        listView = (ListView) findViewById(R.id.listView);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getText().toString().equals("")&&!tags.getText().toString().equals("")
                &&!text.getText().toString().equals("")&&!author.getText().toString().equals("")){
                    Date date = Calendar.getInstance().getTime();
                    Posts post = new Posts(date.toString(),title.getText().toString(),tags.getText().toString(),
                            author.getText().toString(),text.getText().toString());
                    PostsUsersDB.addToPostsList(post);
                    try {
                        FileOutputStream outputStream = new FileOutputStream("localDB.txt");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                        ArrayList<Posts> temp =  PostsUsersDB.getPostsArrayList();
                        objectOutputStream.writeObject(temp);


                    } catch (IOException j) {
                        Log.i("MyTagg","Empty writing posts ");
                    }
                    Intent intent = new Intent(NewPost.this,PostsList.class);
                    startActivity(intent);

                }

            }
        });



    }
}