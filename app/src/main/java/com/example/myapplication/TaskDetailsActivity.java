package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        Button detailsTaskBTN = (Button) findViewById(R.id.btnDetailsProof);
        TextView txtDetailInstruction = (TextView) findViewById(R.id.txtTaskInstructionDetail);
        TextView txtDetailPoints = (TextView) findViewById(R.id.txtTaskPointsDetail);
        TextView txtDetailCompleted = (TextView) findViewById(R.id.txtTaskDetailsCompleted);
        Intent getTaskListIntent = getIntent();
        Bundle getTaskListIntentBundle = getTaskListIntent.getExtras();
        if(getTaskListIntentBundle.getBoolean("completedKey") == true) {
            detailsTaskBTN.setVisibility(View.GONE);
        } else {
            txtDetailCompleted.setVisibility(View.GONE);
        }
        txtDetailInstruction.setText("Task: " + getTaskListIntentBundle.getString("instructionKey"));
        txtDetailPoints.setText(String.valueOf(getTaskListIntentBundle.getInt("ptsKey")) + " coins");

    }
}