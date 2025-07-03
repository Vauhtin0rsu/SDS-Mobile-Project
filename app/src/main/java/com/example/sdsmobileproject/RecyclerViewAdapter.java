package com.example.sdsmobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Exercise> exercises;

    public RecyclerViewAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.exercise_list_row, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        String setsText = exercises.get(position).getSets().toString() + " sets";
        String weightText = exercises.get(position).getWeight() + " kg";
        String repsText = exercises.get(position).getReps() + " reps";

        holder.eNameText.setText(exercises.get(position).getName());
        holder.eSetsText.setText(setsText);
        holder.eWeightText.setText(weightText);
        holder.eRepsText.setText(repsText);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView eNameText, eRepsText, eWeightText, eSetsText;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            eNameText = itemView.findViewById(R.id.eNameText);
            eRepsText = itemView.findViewById(R.id.eRepsText);
            eWeightText = itemView.findViewById(R.id.eWeightText);
            eSetsText = itemView.findViewById(R.id.eSetsText);
            checkBox = itemView.findViewById(R.id.checkBox);

        }
    }
}
