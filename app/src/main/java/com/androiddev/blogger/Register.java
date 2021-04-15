package com.androiddev.blogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Register extends AppCompatActivity implements View.OnClickListener {
        ProgressBar bar ;
        Button signUp;
        TextView email ;
        TextView login ;
        TextView password ;
        TextView passwordConfirm ;
        TextView hasAnAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        signUp = (Button) findViewById(R.id.signInButton);
        email = (TextView) findViewById(R.id.emailTextReg);
        login = (TextView) findViewById(R.id.loginTextReg);
        password = (TextView) findViewById(R.id.PasswordReg);
        passwordConfirm = (TextView) findViewById(R.id.ConfirmPasswordReg);
        hasAnAccount = (TextView) findViewById(R.id.HasAnAccountReg);

        bar = (ProgressBar) findViewById(R.id.ProgressBar);
        signUp.setOnClickListener(this);
        hasAnAccount.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInButton:
                bar.setVisibility(View.VISIBLE);
                checkAccount();
                break;
            case R.id.HasAnAccountReg:
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
                break;

        }
    }

    public void checkAccount(){
        if (!email.getText().toString().equals("")&&!password.getText().toString().equals("")&&
                !passwordConfirm.getText().toString().equals("")&&!login.getText().toString().equals("")){
            if (passwordConfirm.getText().toString().equals(password.getText().toString())){
                newAccount();
                Intent intent = new Intent(Register.this,PostsList.class);
                intent.putExtra("position",login.getText().toString());
                startActivity(intent);
            }
        }
            Toast.makeText(Register.this,"Please enter your data !",Toast.LENGTH_SHORT);
            bar.setVisibility(View.GONE);

    }

    public void newAccount(){
        Users users = new Users(email.getText().toString(),password.getText().toString(),login.getText().toString());
        PostsUsersDB.addToUsersList(users);

        try {
            FileOutputStream outputStream = new FileOutputStream("localDB.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            ArrayList<Users> temp =  PostsUsersDB.getUsersArrayList();
            objectOutputStream.writeObject(temp);


        } catch (IOException j) {
            Log.i("MyTagg","Empty writing users");
        }
    }
}