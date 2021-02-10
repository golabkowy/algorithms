package AOC.Ex5;

import AOC.utils.FR;

import java.io.IOException;
import java.util.List;

public class Ex5 {

    public static class Range {
        public int s;
        public int e;

        public Range(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    private static final int ROWS_RANGE = 127;
    private static final int COLUMNS_RANGE = 7;

    public static Range decodeSeatRowID(String encryptedID, int index, Range range) {
        char[] arr = encryptedID.toCharArray();

        int pivot = calculatePivot(range);

        if (arr[index] == 'F') {
            range.e = pivot - 1;
        } else if (arr[index] == 'B') {
            range.s = pivot;
        }
        if (index == arr.length - 1) {
            return arr[index] == 'F' ? new Range(range.s, range.s) : new Range(range.e, range.e);
        } else {
            index += 1;
            return decodeSeatRowID(encryptedID, index, range);
        }
    }

    public static Range decodeSeatColumnID(String encryptedID, int index, Range range) {
        char[] arr = encryptedID.toCharArray();
        int pivot = calculatePivot(range);

        if (arr[index] == 'L') {
            range.e = pivot - 1;
        } else if (arr[index] == 'R') {
            range.s = pivot;
        }
        if (index == arr.length - 1) {
            return arr[index] == 'L' ? new Range(range.s, range.s) : new Range(range.e, range.e);
        } else {
            index += 1;
            return decodeSeatColumnID(encryptedID, index, range);
        }
    }

    public static int calculatePivot(Range range) {
        return (int) Math.ceil((double) (range.s + range.e) / 2);
    }

    public static int calculateID(int row, int column, int factor) {
        return (row * factor) + column;
    }

    public static final int findHighestID(List<String> input) {
        return input.stream()
                .map(entry -> new String[]{entry.substring(0, 7), entry.substring(7, 10)})
                .map(arr -> new int[]{
                        decodeSeatRowID(arr[0], 0, new Range(0, ROWS_RANGE)).s,
                        decodeSeatColumnID(arr[1], 0, new Range(0, COLUMNS_RANGE)).s
                })
                .map(arr -> calculateID(arr[0], arr[1], 8))
                .sorted()
                .mapToInt(el -> el)
                .max()
                .orElseThrow();
    }

    public static final int[] findAllSeatsIDs(List<String> input) {
        return input.stream()
                .map(entry -> new String[]{entry.substring(0, 7), entry.substring(7, 10)})
                .map(arr -> new int[]{
                        decodeSeatRowID(arr[0], 0, new Range(0, ROWS_RANGE)).s,
                        decodeSeatColumnID(arr[1], 0, new Range(0, COLUMNS_RANGE)).s
                })
                .map(arr -> calculateID(arr[0], arr[1], 8))
                .sorted()
                .mapToInt(el -> el)
                .toArray();
    }

    public static final int findSeatID(int[] data) {
        int lastID = -1;
        for (int i : data) {
            if (lastID != -1 && i - lastID == 2) {
                return i - 1;
            }
            lastID = i;
        }
        return lastID;
    }

    public static void main(String[] args) throws IOException {
        FR fr = new FR();
        List<String> data = fr.readData("C:\\Projects\\algorithms\\src\\main\\java\\AOC\\Ex5\\adv.txt");

        // Ans.1 848
        int result1 = findHighestID(data);
        // Ans.2 682
        int[] allIDs = findAllSeatsIDs(data);
        int result2 = findSeatID(allIDs);
    }
}

