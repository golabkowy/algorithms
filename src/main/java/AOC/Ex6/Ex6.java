package AOC.Ex6;

import AOC.utils.FR;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Ex6 {

    private static int findYesNumberForGroup(List<String> input) {
        input.sort(Comparator.comparingInt(String::length));
        String pattern = input.get(0);
        List<String> data = input.stream()
                .map(u_answs -> {
                    StringBuilder sb = new StringBuilder();
                    for (char c : pattern.toCharArray()) {
                        if (u_answs.contains((String.valueOf(c)))) sb.append(c);
                    }
                    return sb.toString();
                }).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());

        return data.get(0).length();
    }

    public static void main(String[] args) throws IOException {
        FR fr = new FR();
        //AD.1
        List<String> groups = fr.readGroups("C:\\Projects\\algorithms\\src\\main\\java\\AOC\\Ex6\\adv.txt");
        List<Set<Character>> dupa = new ArrayList<>();

        for (int i = 0; i < groups.size(); i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < groups.get(i).length(); j++) {
                list.add(groups.get(i).toCharArray()[j]);
            }
            dupa.add(new HashSet<>(list));
        }
        List<Integer> test = dupa.stream().map(Set::size).collect(Collectors.toList());
        Integer result = test
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);

        //AD.2
        List<List<String>> groups_ad2 = fr.readGroupsAD2("C:\\Projects\\algorithms\\src\\main\\java\\AOC\\Ex6\\adv.txt");
        findYesNumberForGroup(groups_ad2.get(2));

        int result_ad2 = groups_ad2.stream()
                .map(Ex6::findYesNumberForGroup)
                .mapToInt(intGroup -> intGroup)
                .sum();
    }
}

