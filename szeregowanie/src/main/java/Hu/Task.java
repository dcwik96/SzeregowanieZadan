package Hu;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private boolean isFree;
    private int id;
    private int processingTime;
    private int level;
    private List<Integer> successors;
    private List<Integer> predecessors;

    public Task(int id, List<Integer> succesors, List<Integer> predecesors) {
        this.id = id;
        this.processingTime = 1;
        this.level = -1;
        this.successors = new ArrayList<>(succesors);
        this.predecessors = new ArrayList<>(predecesors);
        this.isFree = !this.hasPredecesors() ? true : false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Integer> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Integer> successors) {
        this.successors = successors;
    }

    public List<Integer> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(List<Integer> predecessors) {
        this.predecessors = predecessors;
    }

    public boolean isFree() {
        return isFree;
    }

    public boolean hasPredecesors() {
        return this.predecessors.size() != 0;
    }

    public boolean hasSuccesors() {
        return this.successors.size() != 0;
    }

    public void setFree() {
        this.isFree = true;
    }
}
