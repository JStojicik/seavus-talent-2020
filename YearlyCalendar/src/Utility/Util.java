package Utility;

import java.util.ArrayList;

public final class Util {
    public static ArrayList<String> getDates(int year) {
        int daysInMonth;
        ArrayList<String> dates = new ArrayList<>();
        for (int m = 1; m <= 12; m++) {
            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    daysInMonth = 31;
                    break;
                case 2:
                    if (year % 4 == 0) {
                        daysInMonth = 29;
                    } else {
                        daysInMonth = 28;
                    }
                    break;
                default:
                    daysInMonth = 30;
                    break;
            }
            for(int d=1;d<=daysInMonth;d++){
                String date=year+"/"+m+"/"+d;
                dates.add(date);
            }
        }

        return dates;
    }
}
