//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class Palindroms {
//
//    private static boolean solution(String A, String B) {
//
//        char[] A_char = A.toCharArray();
//        char[] B_char = B.toCharArray();
//
//        if (A.length() != B.length()) {
//            return false;
//        }
//
//        List<Integer> listA = new ArrayList<>();
//        List<Integer> listB = new ArrayList<>();
//
//        for (int i = 0; i < A.length(); i++) {
//            listA.add(Character.getNumericValue(A_char[i]));
//            listB.add(Character.getNumericValue(B_char[i]));
//        }
//
//        //zrobic kopie przed sortowaniem...
//        //albo zalocyc ze w ifie jest inny scope, przez wartość
//        List<Integer> tempA = new ArrayList<Integer>(listA);
//        List<Integer> tempB = new ArrayList<Integer>(listB);
//
//        tempA.sort(Comparator.naturalOrder());
//        tempB.sort(Comparator.naturalOrder());
//
//        //znaczy ze to anagramy...
//        if (tempA.equals(tempB)) {
//            allVariants(listA);
//        }
//
//        return true;
//    }
//
//    private static void swap(int i, int j, List<Integer> list) {
//        int temp = list.get(i);
//        list.set(i, list.get(j));
//        list.set(j, temp);
//
//    }
//
//    private static void allVariants(List<Integer> list) {
//        for ( list.length) {
//
//        }
//    }
//
//    public static void main(String[] args) {
//        solution("12345", "12345");
//    }
//}
