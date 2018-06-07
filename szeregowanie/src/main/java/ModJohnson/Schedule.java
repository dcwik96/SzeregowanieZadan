package ModJohnson;

import java.util.List;

public class Schedule {

    public static void createSchedule(List<Task> toPrint) {
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
                machines[1] += "_";

            for (int i = 0; i < t.getM2(); ++i) {
                machines[1] += t.getId();
            }

            placeToStart = machines[1].lastIndexOf(String.valueOf(t.getId()));

            while (machines[2].length() <= placeToStart)
                machines[2] += "_";

            for (int i = 0; i < t.getM3(); ++i) {
                machines[2] += t.getId();
            }
        }

        for (String s : machines) {
            System.out.println(s);
        }



    }
}
