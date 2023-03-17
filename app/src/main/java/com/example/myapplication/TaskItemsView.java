package com.example.myapplication;

public class TaskItemsView {
    private int taskPoints;
    private String taskInstructions;

    public TaskItemsView(int taskPoints, String taskInstructions) {
        this.taskPoints = taskPoints;
        this.taskInstructions = taskInstructions;
    }

    public int getTaskPoints() {
        return taskPoints;
    }

    public void setTaskPoints(int taskPoints) {
        this.taskPoints = taskPoints;
    }

    public String getTaskInstructions() {
        return taskInstructions;
    }

    public void setTaskInstructions(String taskInstructions) {
        this.taskInstructions = taskInstructions;
    }
}
