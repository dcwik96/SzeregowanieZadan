package ModJohnson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<int[]> machines = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        List<Task> n1 = new ArrayList<>();
        List<Task> n2 = new ArrayList<>();

        try {
            Files.lines(Paths.get("/home/dcwik/Pulpit/SzeregowanieZadan/szeregowanie/src/test/java/CriticalPathMethod/data.txt"))
                    .map((line) -> line.split(" "))
                    .forEach(arr -> machines.add(Arrays.stream(arr)
                            .mapToInt(Integer::parseInt)
                            .toArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int t1 = 0;
        int t2 = 0;

        checkIfDominatedProperly(machines);

        for (int i = 0; i < machines.get(0).length; ++i) {
            t1 = machines.get(0)[i] + machines.get(1)[i];
            t2 = machines.get(1)[i] + machines.get(2)[i];
            tasks.add(new Task(i + 1,machines.get(0)[i], machines.get(1)[i], machines.get(2)[i], t1, t2));

        }

        for (Task t : tasks) {
            if (t.getT1() < t.getT2()) {
                n1.add(t);
            }

            if (t.getT1() >= t.getT2()) {
                n2.add(t);
            }
        }

        n1.sort(Comparator.comparing(Task::getT1));
        n2.sort(Comparator.comparing(Task::getT2).reversed());

        List<Task> toPrint = new ArrayList<>(n1);
        toPrint.addAll(n2);

        createSchedule(toPrint);
    }

    private static void createSchedule(List<Task> toPrint) {
        int placeToStart;
        String[] machines = new String[3];
        machines[0] = ("1)");
        machines[1] = ("2)");
        machines[2] = ("2)");

        for (Task t : toPrint) {

            for (int i = 0; i < t.getM1(); i++) {
                machines[0] += t.getId();
            }

            placeToStart = machines[0].lastIndexOf(String.valueOf(t.getId()));

            while (machines[1].length() <= placeToStart)
                machines[1] += "-";

            for (int i = 0; i < t.getM2(); ++i) {
                machines[1] += t.getId();
            }

            placeToStart = machines[1].lastIndexOf(String.valueOf(t.getId()));

            while (machines[2].length() <= placeToStart)
                machines[2] += "-";

            for (int i = 0; i < t.getM3(); ++i) {
                machines[2] += t.getId();
            }
        }

        for (String s : machines) {
            System.out.println(s);
        }
    }

    private static void checkIfDominatedProperly(List<int[]> machines) throws Exception {
        for (int i = 0; i < machines.get(0).length; ++i) {
            if (machines.get(0)[0] >= machines.get(1)[0]) {
                if (machines.get(0)[i] < machines.get(1)[i]) throw new Exception();
            }
            else if (machines.get(2)[0] >= machines.get(1)[0]){
                if (machines.get(2)[i] < machines.get(1)[i]) throw new Exception();
            }
            else throw  new Exception();
        }
    }
}