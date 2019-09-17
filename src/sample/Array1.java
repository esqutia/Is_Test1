package sample;

public class Array1 {
    public int[] biggerTwo(int[] a, int[] b) {
        if (a[0] + a[1] >= b[0] + b[1])
            return a;
        else
            return b;
    }
}
