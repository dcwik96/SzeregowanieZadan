package CriticalPathMethod;

import java.util.ArrayList;

public class Task {

    //Li = Tp - Tw  jak Li = 0 to krytyczne ZDARZENIE

    private int id;
    private boolean visited = false;
    private int duration;
    //Tw = max (Tw + tij) poprzednikow
    private int earliestStartTime;
    //Tp = min (Tp + tij) nastepnikow
    private int latestStartTime;

    private ArrayList<Integer> successors = new ArrayList<>();
    private ArrayList<Integer> predecessors = new ArrayList<>();

    /**
     * Wszystkie informacje podane w konstruktorze znamy, sa podane z pliku lub wpisane w tescie wywolujacym
     *
     * @param id       - porzadek topologiczny
     * @param duration - czas trwania zadania
     * @param su       - nastepnik
     * @param pre      - poprzednik
     */
    public Task(int id, int duration, int[] su, int[] pre) {
        this.id = id;
        this.duration = duration;

        for (int i : su) {
            this.successors.add(i);
        }

        for (int j : pre) {
            this.predecessors.add(j);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEarliestStartTime() {
        return earliestStartTime;
    }

    public void setEarliestStartTime(int earliestStartTime) {
        this.earliestStartTime = earliestStartTime;
    }

    public int getLatestStartTime() {
        return latestStartTime;
    }

    public void setLatestStartTime(int latestStartTime) {
        this.latestStartTime = latestStartTime;
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nDuration: " + duration + "\nEarliest Start Time: " + earliestStartTime + "\nLatest Start Time: " + latestStartTime + "\n";
    }
}
