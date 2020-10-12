package recurency;

public class RecurencyExamples {

    // w funkcji rekurencyjnej musi byc tzw przypadek podstawowy/trywialny czyli taka wartość argumentu dla której możemy podac wynik
    // bo go znamy / jest obliczalny
    // na etapie przypadku podstawowego powinnismy zakończyć kopiowanie funkcji i zwrócić wynik
    //zatem rekutencja to taka sytuacja kiedy funkcja wywołuje samą siebie aż do momentu odnalezienia przypadku podstawowego

    // ZALETY - w pewnych przypadkach szybsze
    // WADY - zżera ram bo klony funkcji stoją w kolejce w ramie


    static private int calculateSumOfListElements(int[] arr, int index, int sum) {
        sum += arr[index];
        if (index == arr.length - 1) {
            return sum;
        }
        return calculateSumOfListElements(arr, index + 1, sum);
    }

    static private int power(int basis, int exponent) {
        if (exponent == 0) return 1;
        else return basis * power(basis, exponent - 1);
    }
    //example power(2,5)
    // return 2 * power(2,4)
    // return 2 * 2 * power(2,3)
    // return 2 * 2 * 2 power(2,2)
    // return 2 * 2 * 2 * 2 power(2,1)
    // return 2 * 2 * 2 * 2 * 2 * 1

    static private int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static private int simpleFunction(int n) {
        //znamy wzor na f(0) oraz wiemy, że każdy poprzedni wyraz (n-1) jest o 2 mniejszy
        if (n == 0) return 3;
        else return simpleFunction(n - 1) + 2;
    }

    //silnia
    static private long strong(long s) {
        if (s == 0) return 1;
        else return s * strong(s - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(calculateSumOfListElements(arr, 0, 0));
        System.out.println(simpleFunction(3));
        System.out.println(power(2, 8));
    }
}
