import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static final String ASCENDING = "asc";
    public static final String DESCENDING = "desc";

    public static void main(String[] args) throws IOException {
        File file = new File("src/file.txt");
        String fileString = FileUtils.readFileToString(file, "UTF-8").toLowerCase().replaceAll("[^a-zA-Z ]", "");
        Scanner sc = new Scanner(System.in);
        System.out.println("choose the sorting you like for the list of words contained in the file file.txt\n(desc)for descending\n(asc)for ascending");
        String sortType = sc.nextLine();
        System.out.println("choose the minimum length of a word");
        int minLength = Integer.parseInt(sc.nextLine());
        System.out.println("choose the maximum length of a word");
        int maxLength = Integer.parseInt(sc.nextLine());
        wordSorter(fileString, sortType, minLength, maxLength).forEach(System.out::println);
    }

    public static List<String> wordSorter(String fileString, String sortType, int minLength, int maxLength) {
        List<String> invalidList = new ArrayList<>();
        invalidList.add("Invalid sort type");
        if (sortType.toLowerCase().equals(ASCENDING)) {
            return Arrays.stream(fileString.split(" "))
                    .sorted(Comparator.comparingInt(String::length))
                    .filter(s -> maxLength > 0 ? (s.length() <= maxLength && s.length() >= minLength) : s.length() >= minLength)
                    .distinct()
                    .collect(Collectors.toList());
        } else if (sortType.toLowerCase().equals(DESCENDING)) {
            return Arrays.stream(fileString.split(" "))
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .filter(s -> maxLength > 0 ? (s.length() <= maxLength && s.length() >= minLength) : s.length() >= minLength)
                    .distinct()
                    .collect(Collectors.toList());
        } else {
            return invalidList;
        }
    }
}
