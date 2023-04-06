package learn.algorithm.kmp;

/**
 * @author daixulin
 * @version : v1.0
 * @see https://github.com/achilles1010/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E4%B9%8BKMP%E5%AD%97%E7%AC%A6%E5%8C%B9%E9%85%8D%E7%AE%97%E6%B3%95.md
 * @date 2020-05-26 2:58 下午 周二
 */
public class Kmp {
    private int[][] dp;
    private String pat;

    public Kmp(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case 默认遇到pat第一个字符 描述为 0 到 1
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                // j=1 X = 0 dp[0]['A'65] = 1 dp[1]['A'65] = 1 dp[1]['B'66] = 0 dp[1]['C'67] = 0
                // j=2 X = 0 dp[0]['A'65] = 1 dp[2]['A'65] = 1 dp[2]['B'66] = 0 dp[2]['C'67] = 0
                // j=3 X = 1 dp[0]['A'65] = 1 dp[3]['A'65] = 1 dp[3]['B'66] = 0 dp[3]['C'67] = 0
                // j=4 X = 2 dp[0]['A'65] = 1 dp[4]['A'65] = 1 dp[4]['B'66] = 0 dp[4]['C'67] = 0    dp[2]['A'65]=3 dp[4]['A'65]=3
                // 当前影子状态回写到dp组 从当前影子状态从x跳到任何字符都为当前状态跳到任何字符
                dp[j][c] = dp[X][c];

                if (c == 65 || c == 66 || c ==67) {
                    System.out.println("j=" + j + ",c=" + c + ",X=" + X+ ",dp[j][c]=dp[X][c]=" + dp[X][c]);
                }
            }
            // j=1 dp[1]['B'66] = 2;
            // j=2 dp[2]['A'65] = 3;
            // j=3 dp[3]['B'66] = 4;
            // j=4 dp[4]['C'67] = 5;
            dp[j][pat.charAt(j)] = j + 1;
            System.out.println("j=" + j + ",pat.charAt(j)=" + pat.charAt(j) +  ",dp[j][pat.charAt(j)]=" + dp[j][pat.charAt(j)]);
            // 更新影子状态 遇到pat的第二个字符开始
            // j=1 dp[0]['B'66] X = 0
            // j=2 dp[0]['A'65] X = 1
            // j=3 dp[1]['B'66] X = 2
            // j=4 dp[2]['C'67] X = 0
            X = dp[X][pat.charAt(j)];
            System.out.println("X=" + dp[X][pat.charAt(j)] + ",dp[X][pat.charAt(j)]=" + dp[X][pat.charAt(j)]);
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == M) {
                return i - M + 1;
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }

    public static void main(String[] args) {
        Kmp kmp = new Kmp("ABABC");
        int pos1 = kmp.search("AAACAAAB");
        int pos2 = kmp.search("AABABC");
        int pos3 = kmp.search("AABABCCDABABC");

        System.out.println(pos1);;
        System.out.println(pos2);;
        System.out.println(pos3);;
    }
}
