public class BinarySearch {

    static int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 40, 60, 61, 300, 520, 634, 823, 999};

    public static <T extends Comparable> int binarySearch(int[] A, int wanted) {
        int left = 0;
        int right = A.length - 1;
        int index = 0;
        while (left <= right) {
            index = (int) Math.ceil((left + right) / 2);
            if (wanted < A[index]) {
                right = index - 1;
            } else if (wanted > A[index]) {
                left = index + 1;
            } else {
                break;
            }
        }
        return index;
    }

    public static int binarySearchRec(int[] A, int wanted, int left, int right) {
        int index = (int) Math.ceil((left + right) / 2);
        if (wanted < A[index]) {
            return binarySearchRec(A, wanted, left, index - 1);
        } else if (wanted > A[index]) {
            return binarySearchRec(A, wanted, index + 1, right);
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(A, 999));
        System.out.println(binarySearchRec(A, 999, 0, A.length - 1));
    }
}
