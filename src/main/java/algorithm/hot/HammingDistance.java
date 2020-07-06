package algorithm.hot;

/**
 * 汉明问题
 * @author daixulin
 * @version : v1.0
 * @date 2020-07-02 1:59 下午 周四
 */
public class HammingDistance {
    public static int hammingDisV1(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count++;
            z &= z-1;
        }
        return count;
    }

    public static int hammingDisV2(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count++;
            z = z >> 1;
        }
        return count;
    }

    public static int hammingDisV3(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }

    public static void main(String[] args) {
        // 1-> 0001
        // 2-> 0010
        System.out.println(hammingDisV1(1,2));
        System.out.println(hammingDisV2(1,2));
        System.out.println(hammingDisV3(1, 2));
    }
}
