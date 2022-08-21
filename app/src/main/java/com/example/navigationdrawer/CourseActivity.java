package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;


public class CourseActivity extends AppCompatActivity {

    ArrayList personNames = new ArrayList<>(Arrays.asList("Physics", "Chemistry", "Mathematics", "Biology", "English", "Hindi", "PET", "SSC"));
    ArrayList personImages = new ArrayList<>(Arrays.asList(R.drawable.physics, R.drawable.chemistry, R.drawable.mathematics, R.drawable.biology, R.drawable.english, R.drawable.hindi, R.drawable.upssc, R.drawable.ssc));



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2); // you can change grid columns to 3 or more
        recyclerView.setLayoutManager(gridLayoutManager);
        CustomRecyclerViewAdopter customAdapter = new CustomRecyclerViewAdopter(CourseActivity.this, personNames, personImages);
        recyclerView.setAdapter(customAdapter);


    }
}
