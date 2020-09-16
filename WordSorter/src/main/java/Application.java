import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static final String ASCENDING = "asc";
    public static final String DESCENDING = "desc";

    public static void main(String[] args) throws IOException {
        File file = new File("src/file.txt");
        String fileString = FileUtils.readFileToString(file, "UTF-8").toLowerCase().replaceAll("[^a-zA-Z ]", "");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(fileString.split(" ")));
        ArrayList<String> uniqueStringList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("choose the sorting you like for the list of words contained in the file file.txt\n(desc)for descending\n(asc)for ascending");
        String sortType = sc.nextLine();
        for (String s : stringList) {
            int count = 0;
            for (String s1 : stringList) {
                if (s.equals(s1)) {
                    count++;
                }

            }
            if (count == 1) {
                uniqueStringList.add(s);
            }
        }
        if (sortType.toLowerCase().equals(ASCENDING)) {
            uniqueStringList.sort(new AscendingLengthStringComparator());
            uniqueStringList.forEach(System.out::println);
        } else if (sortType.toLowerCase().equals(DESCENDING)) {
            uniqueStringList.sort(new DescendingLengthStringComparator());
            uniqueStringList.forEach(System.out::println);
        } else {
            System.out.println("invalid sort type");
        }

    }
}
