package Hu;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int machineCount = 3;

    public static void main(String[] args) {

        List<Task> tasksList = new ArrayList<>();
        List<Machine> machinesList = new ArrayList<>();

        for (int i = 1; i < machineCount + 1; ++i)
            machinesList.add(new Machine(i));

        tasksList.add(new Task(1, Arrays.asList(7), Arrays.asList()));
        tasksList.add(new Task(2, Arrays.asList(7), Arrays.asList()));
        tasksList.add(new Task(3, Arrays.asList(8), Arrays.asList()));
        tasksList.add(new Task(4, Arrays.asList(9), Arrays.asList()));
        tasksList.add(new Task(5, Arrays.asList(9), Arrays.asList()));
        tasksList.add(new Task(6, Arrays.asList(10), Arrays.asList()));
        tasksList.add(new Task(7, Arrays.asList(10), Arrays.asList(1, 2)));
        tasksList.add(new Task(8, Arrays.asList(11), Arrays.asList(3)));
        tasksList.add(new Task(9, Arrays.asList(11), Arrays.asList(4, 5)));
        tasksList.add(new Task(10, Arrays.asList(12), Arrays.asList(6,7)));
        tasksList.add(new Task(11, Arrays.asList(12), Arrays.asList(8,9)));
        tasksList.add(new Task(12, Arrays.asList(), Arrays.asList(10,11)));

        HuAlgorithm hu = new HuAlgorithm(tasksList, machinesList);
        printGraph(hu);

        hu.eval();

    }

    public static void printGraph(HuAlgorithm path) {
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
