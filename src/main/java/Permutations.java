
import java.util.Arrays;
import java.util.Set;

public class Permutations {

    // arr - elements to make permutations
    // n - number of possible combinations

    public static void perm(int[] arr, int n) {
        if (n == 1) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = 0; i < n; i++) {
            swap(arr, i, n - 1);
            perm(arr, n - 1);

            //OMG CO TO :O swap(arr, i, n - 1);
//            int[] x = new int[3];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = j;
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int N = 3;
        int[] arr = {1, 2, 3, 4};
        perm(arr, N);

//        Set<Set<Integer>> combinations = Sets.combinations(ImmutableSet.of(1, 2, 3, 4), 3);
        System.out.println("test");
    }
}
