import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Application {
    public static void main(String[] args) throws IOException {
        int count = 0;
        File file = new File("src/file.txt");
        String fileString = FileUtils.readFileToString(file, "UTF-8").toLowerCase().replaceAll("[^a-zA-Z ]", "");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(fileString.split(" ")));
        LinkedHashSet<String> stringsCountedList = new LinkedHashSet<>();
        for (String s : stringList) {
            for (String s1 : stringList) {
                if (s.equals(s1)) {
                    count++;
                }
            }
            stringsCountedList.add("<" + s + ">" + " : " + "<" + count + ">");
            count = 0;
        }
        stringsCountedList.forEach(System.out::println);
    }
}
