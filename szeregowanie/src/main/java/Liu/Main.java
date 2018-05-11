package Liu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Task task1 = new Task(1, 3, 4, 0, new int[]{3}, new int[]{});
        Task task2 = new Task(2, 2, 6, 4, new int[]{4}, new int[]{});
        Task task3 = new Task(3, 2, 8, 2, new int[]{5}, new int[]{1});
        Task task4 = new Task(4, 1, 15, 5, new int[]{5, 6}, new int[]{2});
        Task task5 = new Task(5, 4, 10, 6, new int[]{7}, new int[]{4});
        Task task6 = new Task(6, 1, 20, 15, new int[]{7}, new int[]{4});
        Task task7 = new Task(7, 2, 25, 13, new int[]{}, new int[]{5, 6});

        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);

        LiuAlgorithm liuAlgorithm = new LiuAlgorithm(tasks);

        liuAlgorithm.make();
        liuAlgorithm.printInConsoleAllTasksInPath();

    }
}
