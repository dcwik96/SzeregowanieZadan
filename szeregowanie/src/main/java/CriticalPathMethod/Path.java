package CriticalPathMethod;

import java.util.ArrayList;

public class Path {
    ArrayList<Task> tasks;

    public Path(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void findCriticalPath() {
//        if (checkIfAcyc()) {
        setEarliestStartTime();
        setLatestStartTime();
        printCriticalPath();
//        } else throw new IllegalArgumentException();
    }

    public void printCriticalPath() {
        ArrayList<Integer> tasksId = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getLatestStartTime() - task.getEarliestStartTime() == 0) tasksId.add(task.getId());
        }

        for (int i : tasksId) System.out.print(i + " ");
        System.out.println();
    }

    private Task findLatestTask() {
        Task latest = tasks.get(tasks.size() - 1);

        for (int i = tasks.size() - 2; i >= 0; i--) {
            if (latest.getEarliestStartTime() < tasks.get(i).getEarliestStartTime()) latest = tasks.get(i);
        }

        return latest;
    }

    public void setLatestStartTime() {


        for (int i = tasks.size() - 1; i > 0; i--) {
            if (tasks.get(i).getSuccessors().isEmpty())
                tasks.get(i).setLatestStartTime(findLatestTask().getEarliestStartTime() + findLatestTask().getDuration() - tasks.get(i).getDuration());
            else if (tasks.get(i).getSuccessors().size() == 1) {
                tasks.get(i).setLatestStartTime(tasks.get(tasks.get(i).getSuccessors().get(0) - 1).getLatestStartTime() - tasks.get(i).getDuration());
            } else if (tasks.get(i).getSuccessors().size() > 1) {
                tasks.get(i).setLatestStartTime(findMinLatestStartTime(tasks.get(i)));
            }
        }
    }

    private int findMinLatestStartTime(Task task) {
        ArrayList<Integer> times = new ArrayList<>();

        for (int i : task.getSuccessors()) {
            Task su = getTaskById(i);
            int newLatestTme = su.getLatestStartTime() - task.getDuration();
            times.add(newLatestTme);
        }

        int indexOfMinInTimesArray = 0;
        for (int j = 1; j < times.size(); j++) {
            if (times.get(j) < times.get(j - 1)) indexOfMinInTimesArray = j;
        }

        return times.get(indexOfMinInTimesArray);
    }

    public void setEarliestStartTime() {
        for (Task task : tasks) {
            if (task.getPredecessors().isEmpty()) task.setEarliestStartTime(0);
            else if (task.getPredecessors().size() == 1) {
                task.setEarliestStartTime(this.tasks.get(task.getPredecessors().get(0) - 1).getEarliestStartTime() + this.tasks.get(task.getPredecessors().get(0) - 1).getDuration());
            } else if (task.getPredecessors().size() > 1) {
                task.setEarliestStartTime(findMaxEarliestStartTime(task));
            }
        }
    }

    private int findMaxEarliestStartTime(Task task) {
        ArrayList<Integer> times = new ArrayList<>();

        for (int i : task.getPredecessors()) {
            Task pre = getTaskById(i);
            int newEarliestTime = pre.getEarliestStartTime() + pre.getDuration();
            times.add(newEarliestTime);
        }

        int indexOfMaxInTimesArray = 0;
        for (int j = 1; j < times.size(); j++) {
            if (times.get(j) > times.get(j - 1)) indexOfMaxInTimesArray = j;
        }

        return times.get(indexOfMaxInTimesArray);
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

    private boolean checkIfAcyc() {
        for (Task task : tasks) {
            if (task.getSuccessors().size() != 0) {
                for (int i : task.getSuccessors()) {
                    for (int j : getTaskById(i).getSuccessors()) {
                        if (j < task.getId()) return false;
                    }
                }
            }
        }
        return true;
    }

    public void topology() {
        isPeriodicity(tasks.get(0));

        ArrayList<Task> stackOfTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isVisited()) {
                topologicalSortUtil(task, stackOfTasks);
            }
        }

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


    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
