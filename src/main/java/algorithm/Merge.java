package algorithm;

import java.util.Arrays;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-17 3:02 下午 周三
 */
public class Merge {

    private static Comparable[] aux = {1,6,5,4,9,8,10,9,7};

    public static void sort(Comparable[] a) {
       aux = new Comparable[a.length];
       sort(a, 0, a.length -1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo)/2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
       int i = lo, j = mid + 1;
       for (int k = lo; k <= hi; k++) {
           aux[k] = a[k];
       }

       for (int k = lo; k <= hi; k++) {
          if (i > mid)  {
              a[k] = aux[j++];
          } else if (j > hi) {
              a[k] = aux[i++];
          } else if (less(aux[j], aux[i])) {
              a[k] = aux[j++];
          } else {
              a[k] = aux[i++];
          }
       }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(aux));
        sort(aux);
        System.out.println(Arrays.toString(aux));
    }
}
