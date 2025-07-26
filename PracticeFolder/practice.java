package PracticeFolder;

import java.util.Map;
import java.util.stream.Collectors;

public class practice {

    public static void main(String[] args) {
        String str = "banana";

        Map<Character, Long> freq3 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.print(freq3);

        Map<Character, Long> freq2 = str.chars().mapToObj(c->(char) c).collect(Collectors.toMap(c->c,c->1L,(e,n)->e+n));
        Map<Character, Long> freq = str.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.toMap(
        c -> c,                  // keyMapper
        c -> 1L,                 // valueMapper (must be Long, not int)
        Long::sum                // merge function in case of duplicates
    ));
        System.out.print(freq);

    }
}