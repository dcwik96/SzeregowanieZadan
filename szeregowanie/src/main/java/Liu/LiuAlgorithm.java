package Liu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LiuAlgorithm {

    ArrayList<Task> tasks;
    ArrayList<Integer> machine = new ArrayList<>();

    public LiuAlgorithm(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void runLiuAlgorithm() {
        isPeriodicity(tasks.get(0));
        for (Task task : tasks) {
            searchMinEndTime(task);
        }
        algorithm();
        setRealEndTime();
        setLateness();
    }

    private void setLateness() {
        for (Task task : tasks) {
            task.setLateness(task.getRealEndTime() - task.getDeadline());
        }
    }

    private void setRealEndTime() {
        for (Task task : tasks) {
            task.setRealEndTime(machine.lastIndexOf(task.getId()) + 1);
        }
    }

    private void algorithm() {
        int time = 0;
        while (true) {
            Task currentTask = getCurrentTask(time);
            if (currentTask != null) {
                machine.add(currentTask.getId());
                if (currentTask.getDuration() == machine.stream().filter(e -> e == currentTask.getId()).count())
                    currentTask.setFinished(true);
            } else machine.add(0);

            if (!checkIfAnyNotFinish()) {
                break;
            }
            time++;
        }

        print();
    }

    private void print() {
        for (int j = 1; j <= machine.size(); j++) {
            if (j % 5 == 0) System.out.print(j);
            else System.out.print(" ");
        }
        System.out.println();
        for (Integer i : machine) {
            if (i == 0) System.out.print(" ");
            else System.out.print(i);
        }
        System.out.println();
    }

    private boolean checkIfAnyNotFinish() {
        return tasks.stream().anyMatch(e -> !e.isFinished());
    }

    private Task getCurrentTask(int time) {
        List<Task> ts = tasks.stream()
                .filter(e -> e.getStartTime() <= time && !e.isFinished())
                .sorted(Comparator.comparingInt(Task::getEarliestEndTime))
                .collect(Collectors.toList());

        if (ts.size() == 0) {
            return null;
        }

        for (Task t : ts) {
            boolean tasksBeforeFinished = true;
            for (int i : t.getPredecessors()) {
                if (!getTaskById(i).isFinished())
                    tasksBeforeFinished = false;
            }
            if (tasksBeforeFinished) return t;
        }
        return null;
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

    private void isPeriodicity(Task task) {
        if (task.isVisited()) throw new UnsupportedOperationException();

        task.setVisited(true);

        for (int i : task.getSuccessors()) {
            isPeriodicity(getTaskById(i));
        }

        task.setVisited(false);
    }

    private Task getTaskById(int id) {
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

    public void countMaxLateness() {
        System.out.println("MAX LATENESS = " + tasks.stream().max(Comparator.comparing(Task::getLateness)).get().getLateness());
    }
}
