package AOC.Ex2;

import AOC.utils.FR;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Ex2 {
    static class Tuple {
        int min;
        int max;
        char letter;
        String str;

        private Tuple(int min, int max, char letter, String str) {
            this.min = min;
            this.max = max;
            this.letter = letter;
            this.str = str;
        }
    }

    // Ad2.1
    private static long checkValidity(List<Tuple> data) {
        return data.stream()
                .filter(el -> {
                    long number_letter = el.str
                            .chars()
                            .mapToObj(s -> (char) s)
                            .filter(character -> character.equals(el.letter))
                            .count();
                    return number_letter <= el.max && number_letter >= el.min;
                })
                .count();
    }

    // Ad2.2
    private static long checkValidity_2(List<Tuple> data) {
        return data.stream()
                .filter(el -> {
                    if ((el.str.charAt(el.min - 1) == el.letter) && (el.str.charAt(el.max - 1) != el.letter)) {
                        return true;
                    } else return (el.str.charAt(el.min - 1) != el.letter) && (el.str.charAt(el.max - 1) == el.letter);
                })
                .count();
    }

    private static List<Tuple> parseTxtToInput(List<String> lineByLineTXT) {
        return lineByLineTXT.stream().map(line -> {
            String[] sL = line.split(" ");
            int min = Integer.parseInt(sL[0].split("-")[0]);
            int max = Integer.parseInt(sL[0].split("-")[1]);
            char letter = sL[1].charAt(0);
            String str = sL[2];
            return new Tuple(min, max, letter, str);
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        FR fr = new FR();
        System.out.println(checkValidity(parseTxtToInput(fr.readData("C:\\Projects\\algorithms\\src\\main\\java\\AOC\\Ex2\\adv.txt"))));
        System.out.println(checkValidity_2(parseTxtToInput(fr.readData("C:\\Projects\\algorithms\\src\\main\\java\\AOC\\Ex2\\adv.txt"))));
    }
}
