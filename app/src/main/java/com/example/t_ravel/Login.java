package com.example.t_ravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.t_ravel.ui.home.HomeFragment;

public class Login extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail=this.findViewById(R.id.editTextEmailAddress);
        editTextPassword=this.findViewById(R.id.editTextPassword);
    }

    public void loginOnClick(View view) {
        String email= editTextEmail.getText().toString();
        String password=editTextPassword.getText().toString();
        if(email.isEmpty()){
            editTextEmail.setError("Please add an email address");
        }
        else{
            Intent intent=new Intent(Login.this, NavigationDrawer.class);
            startActivity(intent);
        }
    }

    public void newAccount(View view) {
        Intent intent=new Intent(Login.this, CreateAccount.class);
        startActivity(intent);
    }
}