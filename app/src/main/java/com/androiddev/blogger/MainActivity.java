package com.androiddev.blogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView signUp;
    TextView email;
    TextView password;
    Boolean access;
    Button signIn;
    String author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Users user = new Users("zakhidov.44@gmail.com","123","pluxury");
        PostsUsersDB.addToUsersList(user);

        try {
            FileInputStream inputStream = new FileInputStream("localDB.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

             ArrayList<Users> temp = (ArrayList<Users>) objectInputStream.readObject();
             PostsUsersDB.setUsersArrayList(temp);

        } catch (Exception e) {
            Log.i("Mytag","Empty serialization !");
        }


        try {
            FileInputStream inputStream = new FileInputStream("localDB");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            ArrayList<Posts> posts = (ArrayList<Posts>) objectInputStream.readObject();
            PostsUsersDB.setPostsArrayList(posts);

        } catch (Exception e) {
            Log.i("Mytag","Empty serialization ! Posts");
        }


        signUp = (TextView) findViewById(R.id.HasAnAccountReg);
        access = false;
        email = (TextView) findViewById(R.id.loginTextReg);
        password = (TextView) findViewById(R.id.emailTextReg);
        signIn = (Button) findViewById(R.id.signInButton);

        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);



    }


    public void CheckAccount() {
        for (Users user : PostsUsersDB.getUsersArrayList()) {
            if (user.getEmail().equals(email.getText().toString())&&user.getPassword().equals(password.getText().toString())) {
                access = true;
                author = user.getLogin();
                Intent intent2 = new Intent(MainActivity.this,PostsList.class);
                intent2.putExtra("position",user.getLogin());
                startActivity(intent2);
            }
        }if (access==false){
            Toast.makeText(MainActivity.this,"Wrong password or login !",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signInButton:
                CheckAccount();
                break;
            case R.id.HasAnAccountReg:
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                break;

        }
    }
}

