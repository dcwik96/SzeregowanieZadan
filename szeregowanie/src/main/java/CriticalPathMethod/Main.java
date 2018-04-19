package CriticalPathMethod;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

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


        GraphVisualisation applet = new GraphVisualisation();
        applet.init(path);

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("JGraphT Adapter to JGraphX Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
