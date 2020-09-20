import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws IOException {

        File file = new File("src/file.txt");
        String fileString = FileUtils.readFileToString(file, "UTF-8").toLowerCase().replaceAll("[^a-zA-Z ]", "");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(fileString.split(" ")));
        LinkedHashMap<String, Integer> stringsCountedMap = new LinkedHashMap<>();
        for (String s : stringList) {
            int count = 0;
            for (String s1 : stringList) {
                if (s.equals(s1)) {
                    count++;
                }
            }
            stringsCountedMap.put(s, count);
        }
        System.out.println("Each word and the number of times it has been used in the text file will be printed");
        for (Map.Entry<String, Integer> entry : stringsCountedMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }
}
