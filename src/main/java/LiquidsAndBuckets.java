import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LiquidsAndBuckets {

    static class Bucket {
        int volume;
        int content;
        int freeSpace;
//        int possibilities;

        Bucket(int volume, int content) {
            this.volume = volume;
            this.content = content;
            this.freeSpace = volume - content;
        }

        public int getFreeSpace() {
            return freeSpace;
        }

        public int getContent() {
            return content;
        }
    }

    public static int solution(int[] liquid, int[] volume) {
        List<Integer> juicesList = Arrays.stream(liquid)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<Bucket> glasses = new ArrayList<>();    //  zamienic to na arrays.asList stream z listy juiców czy cos

        for (int i = 0; i < juicesList.size(); i++) {
            glasses.add(new Bucket(volume[i], liquid[i]));
        }

        glasses.sort(Comparator.comparingInt(Bucket::getFreeSpace)
                .reversed()
                .thenComparing(Bucket::getContent));

        glasses.sort(Comparator.comparingInt(Bucket::getContent));

        int bestResult = 0;
        for (int i = 0; i < glasses.size(); i++) {
            int result = 1;
            for (int j = 0; j < glasses.size(); j++) {
                if (i == j) continue;
                if (glasses.get(i).freeSpace - glasses.get(j).content >= 0) {
                    result++;
                    glasses.get(i).freeSpace -= glasses.get(j).content;
                } else break;
            }
            if (result > bestResult) bestResult = result;
        }
        return bestResult;
    }

    public static void main(String[] args) {
        // Test cases
//        int[] juice = {2, 2};
//        int[] capacity = {4, 2};

//        int[] juice = {2, 3};
//        int[] capacity = {3, 4};

//        int[] juice = {10, 2, 1, 1};
//        int[] capacity = {10, 3, 2, 2};

//        int[] juice = {1, 2, 3, 4};
//        int[] capacity = {3, 6, 4, 4};

//        int[] juice = {1, 1, 5};
//        int[] capacity = {6, 5, 8};

/**     Each bucket has different liquid, each of them has some volume and liquid level
 *      Find max possibilities to mix liquids
 *      If you pour from one bucket to another, you have to pour it to the end (everything from one bucket to another),
 *      You can not exceed the bucket volume
 */
        int[] liquidLevelsInEachBucket = {2, 5, 5, 5, 5};
        int[] bucketsVolumes = {12, 6, 6, 6, 6};

        System.out.println(solution(liquidLevelsInEachBucket, bucketsVolumes));
    }
}
