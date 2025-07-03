package com.example.sdsmobileproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView nameText;
    private Button addBtn;
    private Button ReadyBtn;

    private TextView execAmountText;

    private EditText editName;
    private EditText editWeight;
    private EditText editReps;
    private EditText editSets;

    private RecyclerView exercise_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameText = findViewById(R.id.nameText);
        addBtn = findViewById(R.id.AddBtn);
        ReadyBtn = findViewById(R.id.ReadyBtn);
        execAmountText = findViewById(R.id.execAmountText);

        editName = findViewById(R.id.editName2);
        editWeight = findViewById(R.id.editWeight2);
        editReps = findViewById(R.id.editReps2);
        editSets = findViewById(R.id.editSets2);

        ArrayList<Exercise> exercises = new ArrayList<>();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editName.getText().toString();

                int newSets;
                try {
                    newSets = Integer.parseInt(editSets.getText().toString());
                } catch (NumberFormatException nfe) {
                    newSets = 3;
                }

                String newReps = editReps.getText().toString();
                if (newReps.isEmpty()) { newReps = "8"; }

                String newWeight = editWeight.getText().toString();
                if (newWeight.isEmpty()) { newWeight = "0"; }

                Exercise e = new Exercise(
                        newName,
                        newSets,
                        newReps,
                        newWeight
                );

                if (!e.getName().isEmpty()) {
                    exercises.add(e);
                }

                String str = "Amount of exercises ready: " + exercises.size();
                execAmountText.setText(str);
            }
        });

        ReadyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showExerciseList = new Intent(getApplicationContext(), ListViewActivity.class);
                showExerciseList.putParcelableArrayListExtra("EXERCISES", exercises);
                startActivity(showExerciseList);
            }
        });

    }

}