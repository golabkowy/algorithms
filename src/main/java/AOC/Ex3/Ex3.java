package AOC.Ex3;

import AOC.utils.FR;

import java.io.IOException;
import java.util.List;


public class Ex3 {
    public static void dataConverter(List<String> ls, char[][] array) {
        for (int i = 0; i < ls.size(); i++) {
            array[i] = ls.get(i).toCharArray();
        }
    }

    public static int checkTrees(int slopeRight, int slopeDown, char[][] array) {
        int treesCoutner = 0;
        for (int i = 1, j = i * slopeRight; i < array.length; i += slopeDown, j += slopeRight) {
            if (array[i][j] == '#')
                treesCoutner++;
        }
        return treesCoutner;
    }

    public static void main(String[] args) throws IOException {
        FR fr = new FR();
        char[][] array;
        List<String> file_data = fr.readData("C:\\Projects\\algorithms\\src\\main\\java\\AOC\\Ex3\\adv.txt");
        array = new char[file_data.size()][];
        dataConverter(file_data, array);

        System.out.println(checkTrees(3, 1, array));    //result
    }
}
