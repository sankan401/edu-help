package com.example.navigationdrawer;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FirebaseAuth auth;
    private EditText username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        email = findViewById(R.id.regemail);
        password = findViewById(R.id.regpassword);
        Button register = findViewById(R.id.regbtn);
        TextView sign=  findViewById(R.id.signup);
        username=findViewById(R.id.username);
        sign.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i = new Intent(Registration.this, Login.class);
                                        startActivity(i);
                                    }
                                });

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(view -> {
            String username = Registration.this.username.getText().toString();
            String email = Registration.this.email.getText().toString();
            String password = Registration.this.password.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(username)) {
                Toast.makeText(getApplicationContext(), "Enter email, password and username ", Toast.LENGTH_SHORT)
                        .show();
            } else {
                regis(email, password);
            }

        });
    }

    private void regis(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Registration.this,
                task -> {
                    if (task.isSuccessful()) {

                        //verification link

                        FirebaseUser user=auth.getCurrentUser();

                       user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void aVoid) {
                               Toast.makeText(Registration.this,"Verification Email has been sent",Toast.LENGTH_SHORT).show();
                           }
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Log.d(TAG,"onFailure:Email not sent "+e.getMessage());
                           }
                       });


                        startActivity(new Intent(getApplicationContext(),Message.class));
                        Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();



                    } else {
                        Toast.makeText(getApplicationContext(), "Registration Failed, Try Again", Toast.LENGTH_SHORT).show();
                    }

                });

    }

}
