package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksAdapterViewHolder> {

    private ArrayList<TaskItemsView> taskListItems = new ArrayList<TaskItemsView>();
    private Context context;
    private ItemClickListener itemClickListener;
    private int LIST_TYPE;

    public TasksAdapter(ArrayList<TaskItemsView> taskListItems, Context context, int LIST_TYPE,ItemClickListener itemClickListener) {
        this.taskListItems = taskListItems;
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.LIST_TYPE = LIST_TYPE;
    }

    @Override
    public TasksAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View taskItem;
        if(LIST_TYPE == 1) {
            taskItem = layoutInflater.inflate(R.layout.custom_tasks_list_view, parent, false);
            TasksAdapterViewHolder viewHolder = new TasksAdapterViewHolder(taskItem);
            return viewHolder;
        } else if (LIST_TYPE == 2) {
            taskItem = layoutInflater.inflate(R.layout.custom_completed_tasks_list_view, parent, false);
            TasksAdapterViewHolder viewHolder = new TasksAdapterViewHolder(taskItem);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(TasksAdapterViewHolder holder, int position) {
        holder.taskInstructions.setText(taskListItems.get(position).getTaskInstructions());
        holder.taskPoints.setText(String.valueOf(taskListItems.get(position).getTaskPoints()) + " coins");
        holder.taskSubmitProofBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(taskListItems.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount(){
        return taskListItems.size();
    }

    public interface ItemClickListener{
        void onItemClick(TaskItemsView taskItemsView);
    }

    public class TasksAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView taskInstructions;
        private TextView taskPoints;
        private Button taskSubmitProofBTN;

        public TasksAdapterViewHolder(View view) {
            super(view);
            taskInstructions = (TextView) view.findViewById(R.id.txtInstruction);
            taskPoints = (TextView) view.findViewById(R.id.txtPoints);
            taskSubmitProofBTN = (Button) view.findViewById(R.id.btnProof);
        }

    }
}
