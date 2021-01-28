import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Olx2 {

    public static int solution(int[] juice, int[] capacity) {

        List<Integer> diffList = new ArrayList<>(juice.length);

        for (int i = 0; i < juice.length; i++) {
            diffList.add(capacity[i] - juice[i]);
        }

//        diffList.sort(Comparator.reverseOrder());
//        diffList.sort(Comparator.naturalOrder());   //sprobowac z dwoma
        Arrays.sort(juice);

        int bestResult = 0;
        for (int i = 0; i < diffList.size(); i++) {
            int result = 1;
            for (int j =0; j < juice.length; j++) {
                if (i == j) continue;
              //  if (tempSize - value >= 0) {//
                    result++;
                    // -= value; // mozliwe ze to juz jest przypix i w ifie się wykonało
               // } else {
                //    break;
               // }
            }
            if (result > bestResult) bestResult = result;
        }
        return bestResult;
    }
}
