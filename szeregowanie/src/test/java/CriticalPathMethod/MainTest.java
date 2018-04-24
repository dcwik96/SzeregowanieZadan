package CriticalPathMethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class MainTest {

    @Test
    @DisplayName("Graf w ktorym jedno z zadan w srodku, ma wiecej niz jednego nastepnika")
    public void taskInsideGotMoreThanOneSuccessor() {
        Task task1 = new Task(1, 7, new int[]{2}, new int[]{});

        Task task2 = new Task(2, 14, new int[]{3, 5}, new int[]{1});

        Task task3 = new Task(3, 11, new int[]{4}, new int[]{2});

        Task task4 = new Task(4, 4, new int[]{7}, new int[]{3});

        Task task5 = new Task(5, 7, new int[]{6}, new int[]{2});

        Task task6 = new Task(6, 4, new int[]{7}, new int[]{5});

        Task task7 = new Task(7, 4, new int[]{8}, new int[]{4, 6});

        Task task8 = new Task(8, 10, new int[]{}, new int[]{7});

        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);

        Path path = new Path(tasks);
        path.findCriticalPath();
        path.printInConsoleAllTasksInPath();

    }

    @Test
    @DisplayName("Graf w ktorym wystepuje wiecej niz jedno zadanie bez nastepnika")
    public void moreThanOneTaskWithoutSuccessor() {
        Task task1 = new Task(1, 2, new int[]{2}, new int[]{});

        Task task2 = new Task(2, 3, new int[]{3,4}, new int[]{1});

        Task task3 = new Task(3, 1, new int[]{6,7,8}, new int[]{2});

        Task task4 = new Task(4, 4, new int[]{5,8}, new int[]{2});

        Task task5 = new Task(5, 2, new int[]{8}, new int[]{4});

        Task task6 = new Task(6, 3, new int[]{}, new int[]{3});

        Task task7 = new Task(7, 3, new int[]{}, new int[]{3});

        Task task8 = new Task(8, 5, new int[]{}, new int[]{3,4,5});

        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);

        Path path = new Path(tasks);
        path.findCriticalPath();
        path.printInConsoleAllTasksInPath();
    }

    @Test
    @DisplayName("Graf w ktorym wystepuje wiecej niz jedno zadanie bez poprzednika")
    public void moreThanOneTaskWithoutPredecessor() {
        Task task1 = new Task(1, 2, new int[]{2}, new int[]{});

        Task task2 = new Task(2, 3, new int[]{4}, new int[]{1});

        Task task3 = new Task(3, 1, new int[]{6,7,8}, new int[]{});

        Task task4 = new Task(4, 4, new int[]{5,8}, new int[]{2});

        Task task5 = new Task(5, 2, new int[]{8}, new int[]{4});

        Task task6 = new Task(6, 3, new int[]{}, new int[]{3});

        Task task7 = new Task(7, 3, new int[]{}, new int[]{3});

        Task task8 = new Task(8, 5, new int[]{}, new int[]{3,4,5});

        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);

        Path path = new Path(tasks);
        path.findCriticalPath();
        path.printInConsoleAllTasksInPath();
    }
}
