package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity
{
    TextView username;
    TextView password;
    Button loginbtn;
    FirebaseAuth auth;
    TextView newuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        newuser=(TextView) findViewById(R.id.signup);
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i = new Intent(Login.this, Registration.class);
                startActivity(i);
            }
        });

        auth = FirebaseAuth.getInstance();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = username.getText().toString();
                String password1 = password.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password1)) {
                    Toast.makeText(Login.this, "Enter email and password", Toast.LENGTH_SHORT).show();
                }  else {
                    log(email, password1);
                }
            }
        });
    }

    private void log(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(Login.this,
                new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {


                        Intent loginbtn = new Intent(Login.this, Verification.class);
                        startActivity(loginbtn);

                    }

                });

    }
}
