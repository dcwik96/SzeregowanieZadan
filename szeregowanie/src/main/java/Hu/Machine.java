package Hu;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private int id;
    private List<Integer> tasksIds;

    public Machine(int i) {
        this.id = i;
        this.tasksIds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getTasksIds() {
        return tasksIds;
    }

    public void setTasksIds(List<Integer> tasksIds) {
        this.tasksIds = tasksIds;
    }

    public void insertTask(int taskId) {
        this.tasksIds.add(taskId);
    }
}
