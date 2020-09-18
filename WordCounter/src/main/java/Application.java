import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Application {
    public static void main(String[] args) throws IOException {

        File file = new File("src/file.txt");
        String fileString = FileUtils.readFileToString(file, "UTF-8").toLowerCase().replaceAll("[^a-zA-Z ]", "");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(fileString.split(" ")));
        LinkedHashSet<String> stringsCountedSet = new LinkedHashSet<>();
        for (String s : stringList) {
            int count = 0;
            for (String s1 : stringList) {
                if (s.equals(s1)) {
                    count++;
                }
            }
            stringsCountedSet.add("<" + s + ">" + " : " + "<" + count + ">");
        }
        stringsCountedSet.forEach(System.out::println);
    }
}
