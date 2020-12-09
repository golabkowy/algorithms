package BinarySearch;

public class ComparableObject implements Comparable<ComparableObject> {

    private String str;
    private int number;

    public ComparableObject(String str, int number) {
        this.str = str;
        this.number = number;
    }

    @Override
    public int compareTo(ComparableObject o) {
        return this.number > o.number ? 1 : (this.number < o.number ? -1 : 0);
    }
}
