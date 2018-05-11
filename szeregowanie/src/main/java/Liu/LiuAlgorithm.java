package Liu;

import java.util.ArrayList;
import java.util.Collections;

public class LiuAlgorithm {

    ArrayList<Task> tasks;

    public LiuAlgorithm(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void make() {
//        topology();
        isPeriodicity(tasks.get(0));
        for (Task task : tasks) {
            searchMinEndTime(task);
            setRealEndTime(task);
        }

    }

    private void setRealEndTime(Task task) {
//        for ()
    }

    private void searchMinEndTime(Task task) {
        int minimal = task.getDeadline();
        task.setEarliestEndTime(minimal);
        for (int i : task.getSuccessors()) {
            if (getTaskById(i).getDeadline() < minimal) {
                minimal = getTaskById(i).getDeadline();
                task.setEarliestEndTime(minimal);
            }
            searchMinEndTime(getTaskById(i));
        }
    }

    private void topology() {
        isPeriodicity(tasks.get(0));

        ArrayList<Task> stackOfTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isVisited()) {
                topologicalSortUtil(task, stackOfTasks);
            }
        }

        Collections.reverse(stackOfTasks);
        this.tasks = stackOfTasks;
    }

    private void isPeriodicity(Task task) {
        if (task.isVisited()) throw new UnsupportedOperationException();

        task.setVisited(true);

        for (int i : task.getSuccessors()) {
            isPeriodicity(getTaskById(i));
        }

        task.setVisited(false);
    }

    private void topologicalSortUtil(Task task, ArrayList<Task> stackOfTasks) {
        task.setVisited(true);

        for (int j : task.getSuccessors()) {
            if (!getTaskById(j).isVisited()) {
                topologicalSortUtil(getTaskById(j), stackOfTasks);
            }
        }

        stackOfTasks.add(task);

    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void printInConsoleAllTasksInPath() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
