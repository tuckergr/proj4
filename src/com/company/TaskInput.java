package com.company;

import java.util.ArrayList;

class TaskInput {
    public ArrayList<Task> tasks = new ArrayList<Task>();

    private Task createNewTask(String name, String desc, int prio) {
        return new Task(name, desc, prio);
    }
    public ArrayList<Task> addTask(String name, String desc, int prio) {
        this.tasks.add(createNewTask(name, desc, prio));
        return tasks;
    }
    public void removeTask(int i) {
        if (this.tasks.size() > i)
            this.tasks.remove(i);
    }
    public void updateTask(int index, String name, String desc, int prio) {
        this.tasks.set(index, createNewTask(name, desc, prio));
    }
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
    public ArrayList<Task> listTasks(){
        return tasks;
    }
    public ArrayList<Task> getTasks(int prio) {
        ArrayList<Task> prioMatch = new ArrayList<Task>();
        for (Task task : this.tasks) {
            if (task.getPrio() == prio)
                prioMatch.add(task);
        }
        return prioMatch;
    }
}
