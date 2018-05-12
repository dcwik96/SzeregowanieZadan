package Liu;

import java.util.ArrayList;

public class Task {
    private int id;
    private boolean visited = false;
    private boolean finished = false;
    private int duration;
    private int deadline;
    private int startTime;
    private int earliestEndTime;
    private int realEndTime;

    private int lateness;

    private ArrayList<Integer> successors = new ArrayList<>();
    private ArrayList<Integer> predecessors = new ArrayList<>();

    public Task(int id, int duration, int deadline, int startTime, int[] su, int[] pre) {
        this.id = id;
        this.duration = duration;
        this.deadline = deadline;
        this.startTime = startTime;

        for (int i : su) {
            this.successors.add(i);
        }

        for (int j : pre) {
            this.predecessors.add(j);
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEarliestEndTime() {
        return earliestEndTime;
    }

    public void setEarliestEndTime(int earliestEndTime) {
        this.earliestEndTime = earliestEndTime;
    }

    public ArrayList<Integer> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<Integer> successors) {
        this.successors = successors;
    }

    public ArrayList<Integer> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(ArrayList<Integer> predecessors) {
        this.predecessors = predecessors;
    }

    public int getLateness() {
        return lateness;
    }

    public void setLateness(int lateness) {
        this.lateness = lateness;
    }

    public int getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(int realEndTime) {
        this.realEndTime = realEndTime;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\nduration=" + duration +
                "\ndeadline=" + deadline +
                "\nstartTime=" + startTime +
                "\nearliestEndTime=" + earliestEndTime +
                "\nlateness=" + lateness;
    }
}
