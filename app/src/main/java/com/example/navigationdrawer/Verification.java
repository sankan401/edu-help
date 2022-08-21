package com.example.navigationdrawer;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Verification extends AppCompatActivity {
    FirebaseAuth fAuth;

    TextView text,warning;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification);
        fAuth=FirebaseAuth.getInstance();

        text=findViewById(R.id.text);
        warning=findViewById(R.id.warning);
        button=findViewById(R.id.button);

        FirebaseUser user=fAuth.getCurrentUser();

        if(user.isEmailVerified()){

            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }
        else{

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (final View view) {

                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(view.getContext(), "Verification Email has been sent",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("tag","onFailure:Email not sent "+e.getMessage());
                        }
                    });
                }
            });
        }


    }
}