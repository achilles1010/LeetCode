package learn.structrue;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-28 上午10:02 周三
 */
public class BitMapC {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        Set<Integer> output = new HashSet<>();
        int i = 0;
        int[] t = {1,2,3,4,5,6,7,8,3,4};

        while (i < t.length) {
            int value  = t[i];
            if (bitSet.get(value)) {
                output.add(value);
            } else {
                bitSet.set(value, true);
            }

            i++;
        }

        System.out.println(output);
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(100));
    }
}
