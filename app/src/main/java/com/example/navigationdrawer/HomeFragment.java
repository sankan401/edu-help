package com.example.navigationdrawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment {
    ImageView ncer;
    ImageView sarkari;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ncer = v.findViewById(R.id.ncert);
        sarkari = v.findViewById(R.id.sarkariresult);


        sarkari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.sarkariresult.com/");

            }
        });

        ncer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://ncert.nic.in/");

            }
        });
        return v;
    }


        private void gotoUrl(String s){
            Uri uri=Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));

        }




}