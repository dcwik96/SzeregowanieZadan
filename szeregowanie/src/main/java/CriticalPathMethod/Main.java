package CriticalPathMethod;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

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
//        path.topology();
        path.findCriticalPath();
        path.printInConsoleAllTasksInPath();

        printGraph(path);
    }

    public static void printGraph(Path path) {
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
