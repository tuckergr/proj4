package com.company;

class Task implements Comparable<Task> {
    private String name;
    private String desc;
    private int prio;

    public Task(String name, String desc, int prio) {
        this.name = name;
        this.desc = desc;
        this.prio = prio;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getPrio() {
        return prio;
    }
    public void setPrio(int prio) {
        if (prio < 0) {
            this.prio = 0;
        } else if (prio > 5) {
            this.prio = 5;
        } else {
            this.prio = prio;
        }
    }

    @Override
    public String toString() {
        return "Tasks " +
                "\nName: " + name+
                "\nDescription: " + desc +
                "\nPriority: " + prio +
                "\n";
    }

    @Override
    public int compareTo(Task o) {
        if(this.getPrio() > o.getPrio())
            return 1;
        else
            return -1;
    }
}
