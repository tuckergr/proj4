package com.company;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ViewTask extends TaskInput{
    private Scanner scanner = new Scanner(System.in);
    private TaskInput taskInput;

    ViewTask(TaskInput collection) {
        this.taskInput = collection;
    }
    boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }catch(NullPointerException e) {
            return false;
        }finally {
            return true;
        }
    }
    public String prompt(String a) {
        System.out.println(a);
        return this.scanner.nextLine();
    }
    public int promptInt(String a) {
        String b = prompt(a);
        boolean isInt = isInteger(b);
        while (!isInt) {
            b = prompt(a);
            isInt = isInteger(b);
        }
        return Integer.parseInt(b);
    }
    public void addTasks() {
        String name = prompt("Enter the tasks name");
        String description = prompt("Enter the tasks description");
        int priority = promptInt("Enter the tasks priority");
        this.taskInput.addTask(name, description, priority);
    }
    public void removeTasks() {
        int index = promptInt("Enter the index of the task to remove.");
        this.taskInput.removeTask(index);
    }
    public void updateTasks() {
        int a = promptInt("Enter the index of the task to update.");
        String rename = prompt("Enter the new name.");
        String newDesc = prompt("Enter the new Description");
        int newPrio = promptInt("Enter the new priority");
        this.taskInput.updateTask(a, rename, newDesc, newPrio);
    }
    public void display(ArrayList<Task> tasks) {
        for (Task a: tasks) {
            System.out.println(a);
        }
    }
    public void listAllTasks(){
        display(this.taskInput.getTasks());
    }
    public void listByPrio() {
        int priority = promptInt("Enter a priority");
        display(this.taskInput.getTasks(priority));
    }
    static Gson gson = new Gson();
    static File dataSave = new File("C:\\Users\\078891\\IdeaProjects\\proj4\\data.json");
    static FileReader fileReader;

    static {
        try{
            fileReader = new FileReader(dataSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean endLoop = false;
        while (!endLoop) {
            System.out.println("(1) Add a task.\n" +
                    "(2) Remove a task.\n" +
                    "(3) Update a task.\n" +
                    "(4) List all tasks.\n" +
                    "(5) List all tasks by priority.\n" +
                    "(0) Exit.");
            int userInput = promptInt("Choose an option.");
            switch (userInput) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    removeTasks();
                    break;
                case 3:
                    updateTasks();
                    break;
                case 4:
                    Collections.sort(this.taskInput.getTasks());
                    listAllTasks();
                    break;
                case 5:
                    listByPrio();
                    break;
                case 0:
                    endLoop = true;
                    break;
            }
        }
    }
}

