import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Application {

    public static final String ASCENDING = "asc";
    public static final String DESCENDING = "desc";

    public static void main(String[] args) throws IOException {
        File file = new File("src/file.txt");
        String fileString = FileUtils.readFileToString(file, "UTF-8").toLowerCase().replaceAll(",", "").replaceAll("[.]", "");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(fileString.split(" ")));
        Scanner sc = new Scanner(System.in);
        System.out.println("choose the sorting you like for the list of words contained in the file file.txt\n(desc)for descending\n(asc)for ascending");
        String sortType = sc.nextLine();
        try {
            System.out.println("choose the minimum length of a word");
            int minLength = Integer.parseInt(sc.nextLine());
            System.out.println("choose the maximum length of a word");
            int maxLength = Integer.parseInt(sc.nextLine());
            if (sortType.toLowerCase().equals(ASCENDING)) {
                stringList.stream().sorted(Comparator.comparingInt(String::length)).filter(s -> maxLength > 0 ? (s.length() <= maxLength && s.length() >= minLength) : s.length() >= minLength).distinct().forEach(System.out::println);
            } else if (sortType.toLowerCase().equals(DESCENDING)) {
                stringList.stream().sorted((s1, s2) -> s2.length() - s1.length()).filter(s -> s.length() <= maxLength && s.length() >= minLength).distinct().forEach(System.out::println);
            } else {
                System.out.println("invalid sort type");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("please enter a number");
            nfe.printStackTrace();
        }
    }
}
