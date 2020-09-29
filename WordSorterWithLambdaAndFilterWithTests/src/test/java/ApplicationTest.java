import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ApplicationTest {
    @Test
    void wordSorter_Asc() {
        List<String> actualList = new ArrayList<>();
        actualList.add("big");
        actualList.add("house");
        List<String> resultList = Application.wordSorter("big house", "asc", 0, 0);

        Assertions.assertEquals(actualList, resultList);
    }

    @Test
    void wordSorter_Desc() {
        List<String> actualList = new ArrayList<>();
        actualList.add("house");
        actualList.add("big");
        List<String> resultList = Application.wordSorter("big house", "desc", 0, 0);

        Assertions.assertEquals(actualList, resultList);
    }

    @Test
    void wordSorter_MaxLength() {
        List<String> actualList = new ArrayList<>();
        actualList.add("big");
        List<String> resultList = Application.wordSorter("big house", "desc", 0, 4);
        Assertions.assertEquals(actualList, resultList);
    }

    @Test
    void wordSorter_MinLength() {
        List<String> actualList = new ArrayList<>();
        actualList.add("house");
        List<String> resultList = Application.wordSorter("big house", "desc", 4, 0);
        Assertions.assertEquals(actualList, resultList);
    }

    @Test
    void wordSorter_InvalidSort() {
        List<String> actualList = new ArrayList<>();
        actualList.add("Invalid sort type");
        List<String> resultList = Application.wordSorter("big house", "descc", 4, 0);
        Assertions.assertEquals(actualList, resultList);
    }

}