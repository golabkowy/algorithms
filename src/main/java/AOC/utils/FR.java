package AOC.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FR {
    private String path;

    public FR() {

    }

    public FR(String path) {
        this.path = path;
    }

    public List<String> readData(String pathname) throws IOException {
        List<String> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathname));
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    //EX6 - specific
    public List<String> readGroups(String pathname) {
        List<String> data = new ArrayList<>();
        StringBuilder group = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(pathname));
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                if (temp.isBlank()) {
                    data.add(group.toString());
                    group = new StringBuilder();
                } else {
                    group.append(temp);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<List<String>> readGroupsAD2(String pathname) {
        List<List<String>> groups = new ArrayList<>();
        List<String> group = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathname));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                if (user.isBlank()) {
                    groups.add(group);
                    group = new ArrayList<>();
                } else {
                    group.add(user);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public void writeToEndOfLine(int lineNumber, String data) throws IOException {
        FileWriter fr = new FileWriter("C:\\Projects\\algorithms\\src\\main\\java\\AOC\\Ex3\\adv.txt", true);
        char[][] arrayka = new char[5][];

        arrayka[0] = "aaaaa\n".toCharArray();
        arrayka[1] = "bbbbb\n".toCharArray();
        arrayka[2] = "ccccc\n".toCharArray();
        arrayka[3] = "ddddd\n".toCharArray();
        arrayka[4] = "eeeee\n".toCharArray();

        Arrays.stream(arrayka).forEach(ar2d -> {
            try {
                fr.write(ar2d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fr.close();
    }
}
