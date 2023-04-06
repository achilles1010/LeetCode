package learn.algorithm;

import java.util.ArrayList;

/**
 * The type Binary search. https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/er-fen-cha-zhao-xiang-jie
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-18 1:58 下午 周四
 */
public class BinarySearch {
    /**
     * Binary search v 1 int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public static int binarySearchV1(int[] nums, int target)  {
       int left = 0;
       int right = nums.length - 1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (nums[mid] == target) {
               return mid;
           } else if (nums[mid] < target) {
               left = mid + 1;
           } else if (nums[mid] > target) {
               right = mid - 1;
           }
       }

       return -1;
   }

    /**
     * Binary search left bound int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public static int binarySearchLeftBound(int[] nums, int target) {
       if (nums.length == 0) {
           return -1;
       }

       int left  = 0;
       int right = nums.length;

       while(left < right) {
           int mid = (left + right) / 2;
           if (nums[mid] == target) {
               right = mid;
           } else if (nums[mid] < target) {
               left = mid + 1;
           } else if (nums[mid] > target) {
               right = mid;
           }
       }

//       return left;

       if (left == nums.length) {
           return -1;
       }

       return nums[left] == target ? left : -1;
   }

    /**
     * Binary search left bound v 2 int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public static int binarySearchLeftBoundV2(int[] nums, int target) {
        int left  = 0;
        int right = nums.length -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 不返回 锁定左侧边界;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    /**
     * Binary search v 2 int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public static int binarySearchV2(int[] nums, int target) {
        int left  = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                // [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // [left, mid-1]
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    /**
     * Binary search right bound int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public static int binarySearchRightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left  = 0;
        int right = nums.length;

        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

//       return left;

        if (left == 0) {
            return -1;
        }

        return nums[left - 1] == target ? left - 1  : -1;
    }

    /**
     * Binary search right bound v 2 int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public static int binarySearchRightBoundV2(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                // 锁定右侧边界
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }

    /**
     * Binary search v 3 int.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int
     */
    public static int binarySearchV3(int[] nums, int target) {
        int left  = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 收缩右侧边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                // [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // [left, mid-1]
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return  -1;
        }

        return right;
    }

    /**
     * Gets max.
     *
     * @param piles the piles
     * @return the max
     */
    int getMax(int[] piles) {
       int max = 0;
       for (int n : piles) {
           max = Math.max(n, max);
       }
       return max;
    }

    /**
     * Can finish boolean.
     *
     * @param piles the piles
     * @param speed the speed
     * @param H     the h
     * @return the boolean
     */
    boolean canFinish(int [] piles, int speed, int H) {
       int time = 0;
      for (int n : piles)  {
          time += timeOf(n, speed);
      }
      return time <= H;
    }

    /**
     * Time of int.
     *
     * @param n     the n
     * @param speed the speed
     * @return the int
     */
    int timeOf(int n, int speed) {
       return (n / speed) + ((n % speed > 0) ? 1: 0);
    }

    /**
     * Min eating speed int.
     *
     * @param piles the piles
     * @param H     the h
     * @return the int
     */
    int minEatingSpeed(int[] piles, int H) {
        // 最小速度
       int left = 1, right = getMax(piles) + 1;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (canFinish(piles, mid, H)) {
               right = mid;
           } else {
               left = mid + 1;
           }
       }

       return left;
    }

    /**
     * Can finish v 2 boolean. https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/koko-tou-xiang-jiao
     *
     * @param w   the w
     * @param D   the d
     * @param cap the cap
     * @return the boolean
     */
    boolean canFinishV2(int[] w, int D, int cap) {
       int i = 0;
       for (int day = 0; day < D; day++) {
           int maxCap = cap;
           while ((maxCap -= w[i]) >= 0) {
               i++;
               if (i == w.length) {
                   return true;
               }
           }
       }
       return false;
    }

    /**
     * Gets sum.
     *
     * @param weights the weights
     * @return the sum
     */
    int getSum(int[] weights) {
       int sum = 0;
       for (int n : weights) {
           sum += n;
       }
       return sum;
    }

    /**
     * Ship within days int.
     *
     * @param weights the weights
     * @param D       the d
     * @return the int
     */
// 最低运载能力
    int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights);
        int right = getSum(weights) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Left bound int.
     *
     * @param arr the arr
     * @param tar the tar
     * @return the int
     */
    int leftBound(ArrayList<Integer> arr, int tar){
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi-lo) /2;
            if (tar > arr.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    /**
     * Is sub sequence boolean. https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/er-fen-cha-zhao-pan-ding-zi-xu-lie
     *
     * @param s the s
     * @param t the t
     * @return the boolean
     */
    boolean isSubSequence(String s, String t) {
        int m = s.length(), n = t.length();

        // 检索位置
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }

        // 串t指针
        int j = 0;
        // 借助index 查找s[i]
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);

            // t上没有字符c
            if (index[c] == null) {
                return false;
            }

            int pos = leftBound(index[c], j);

            // 二分搜索区间中没有找到字符c
            if (pos == index[c].size()) {
                return false;
            }

            // 指向t的第j位
            j = index[c].get(pos) + 1;
        }

        return true;
    }
}
