package com.example.sdsmobileproject;

import android.os.Bundle;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private RecyclerView exerciseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        exercises = getIntent().getExtras().getParcelableArrayList("EXERCISES");

        exerciseView = findViewById(R.id.exerciseView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, exercises);
        exerciseView.setAdapter(adapter);
        exerciseView.setLayoutManager(new LinearLayoutManager(this));
        
    }
}