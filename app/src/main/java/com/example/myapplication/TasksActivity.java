package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;


public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        ArrayList<TaskItemsView> incompleteTaskListItems = new ArrayList<TaskItemsView>();
        incompleteTaskListItems.add(new TaskItemsView(50,"Plant a tree"));
        incompleteTaskListItems.add(new TaskItemsView(35, "Recycle plastic"));
        incompleteTaskListItems.add(new TaskItemsView(100,"Clean trash around your area"));
        incompleteTaskListItems.add(new TaskItemsView(500,"Use eco-friendly fertilizers"));
        incompleteTaskListItems.add(new TaskItemsView(600,"Use energy efficient products"));

        ArrayList<TaskItemsView> completeTaskListItems = new ArrayList<TaskItemsView>();
        completeTaskListItems.add(new TaskItemsView(60,"Sort your trash"));
        completeTaskListItems.add(new TaskItemsView(40,"Save water"));
        completeTaskListItems.add(new TaskItemsView(24,"Turn off unused electrical appliances"));
        completeTaskListItems.add(new TaskItemsView(300,"Reduce your carbon footprint"));
        completeTaskListItems.add(new TaskItemsView(500,"Donate items and/or money to a non-government organization to help nature."));

        Intent intentToTaskDetails = new Intent(this, TaskDetailsActivity.class);

        RecyclerView incompleteTasksRC = (RecyclerView) findViewById(R.id.taskRecyclerView);
        TasksAdapter incompleteTasksAdapter = new TasksAdapter(incompleteTaskListItems, this, 1 ,new TasksAdapter.ItemClickListener() {
            @Override
            public void onItemClick(TaskItemsView taskItemsView) {
                intentToTaskDetails.putExtra("instructionKey",taskItemsView.getTaskInstructions());
                intentToTaskDetails.putExtra("ptsKey",taskItemsView.getTaskPoints());
                intentToTaskDetails.putExtra("completedKey", false);
                startActivity(intentToTaskDetails);
            }
        });
        incompleteTasksRC.setLayoutManager(new LinearLayoutManager(this));
        incompleteTasksRC.setAdapter(incompleteTasksAdapter);

        RecyclerView completeTasksRC = (RecyclerView) findViewById(R.id.completedTaskRecyclerView);
        TasksAdapter completeTasksAdapter = new TasksAdapter(completeTaskListItems, this, 2 ,new TasksAdapter.ItemClickListener() {
            @Override
            public void onItemClick(TaskItemsView taskItemsView) {
                intentToTaskDetails.putExtra("instructionKey",taskItemsView.getTaskInstructions());
                intentToTaskDetails.putExtra("ptsKey",taskItemsView.getTaskPoints());
                intentToTaskDetails.putExtra("completedKey", true);
                startActivity(intentToTaskDetails);
            }
        });
        completeTasksRC.setLayoutManager(new LinearLayoutManager(this));
        completeTasksRC.setAdapter(completeTasksAdapter);
    }
}