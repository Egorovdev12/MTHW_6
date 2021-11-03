package HW;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String SOURCE = "    aBlam sHa la cHHu SHa lAlAla   ";

    public static void main(String[] args) {

        StringRecognizer mhf = (a) -> {
            String decoded = a.strip().toLowerCase(Locale.getDefault());
            return decoded;
        };


        List<String> strList = createDictionary(SOURCE, mhf);
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(i + 1 + ") " + strList.get(i));
        }
    }


    public static List<String> createDictionary(String source, StringRecognizer function) {
          return Arrays.asList(Arrays.asList(source).stream()
                .map(function::restoreStr)
                .toList()
                .get(0)
                .split(" "))
                .stream()
                .distinct()
                  .sorted()
                  .collect(Collectors.toList());
    }
}
