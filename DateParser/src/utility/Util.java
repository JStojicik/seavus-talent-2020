package utility;

import java.util.ArrayList;
import java.util.Arrays;

public interface Util {
    static void dateList(String date) {
        ArrayList<String> dateList = new ArrayList<>(Arrays.asList(date.split("/")));
        for (int i = 0; i < dateList.size(); i++) {
            switch (i) {
                case 0:
                    System.out.println("Month: " + dateList.get(i));
                    break;
                case 1:
                    System.out.println("Day: " + dateList.get(i));
                    break;
                case 2:
                    System.out.println("Year: " + dateList.get(i));
                    break;
            }
        }
    }
}
