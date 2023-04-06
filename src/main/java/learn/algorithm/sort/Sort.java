package learn.algorithm.sort;

import java.util.Arrays;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-22 10:54 上午 周一
 */
public class Sort {

    public static int[] bubbleSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 遍历数组长度次数
            boolean flag = true;

            for (int j = 0 ; j < arr.length - 1; j++) {

                // 相邻元素比较 如果前一个元素大于后一个元素 元素值互换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+ 1] = tmp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

        return arr;
    }

    public static int[] selectionSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 比较n - 1次
        for (int i = 0 ; i < arr.length - 1; i++) {

            // 预设从第i位最小元素位置
            int min = i;

            // 每轮比较 n-i
            for (int j = i + 1; j < arr.length; j++) {

                // 如果j位元素值小于min位 j赋值min
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 如果当前最小位不是i 则将i位的元素和min位元素互换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }

        return arr;
    }

    public static int[] insertSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从小标为1的元素开始选择合适的位置插入 因为下标为0的只有一个元素 默认是啊有序的
        for (int i =1; i < arr.length; i++) {
            // 记录要插入的元素
            int tmp = arr[i];

            int j = i;

            // 开始比较 如果插入元素比前位元素大 则置插入元素位等于前位元素 继续下一位判断
            while (j > 0 && tmp < arr[j-1]) {
                arr[j] = arr[j -1];
                j--;
            }

            // 存在比其小的数 插入 开始i=j
            if (j != i) {
                arr[j] = tmp;
            }

        }

        return arr;
    }

    public static int[] shellSort(int[] sourceArray) {
        // {9,1,3,5,4,2,1,0,6} arr.length=9
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;

        // gap为 1 4 7 10 13 ...
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            // gap = 4 1
            for (int i = gap ; i < arr.length; i++) {

                int tmp = arr[i];
                int j = i - gap;

                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = Math.floorDiv(gap , 3);
        }

        return arr;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        System.out.println("left:"+ Arrays.toString(left));
        System.out.println("right:"+ Arrays.toString(right));
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left , 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        System.out.println("result:"+ Arrays.toString(result));
        return result;
    }

    public static int[] mergeSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return  arr;
        }

        int middle = Math.floorDiv(arr.length, 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        int[] s =  merge(mergeSort(left), mergeSort(right));

        System.out.println("------------------------");
        System.out.println("arr:"+ Arrays.toString(s));
        return s;
    }

    public static void main(String[] args) {
       int[] arr = {9,1,3,5,4,2,1,0,6};
//        int[] arr = {9,4,3,5,1};
//        System.out.println(Arrays.toString(bubbleSort(arr)));
//        System.out.println(Arrays.toString(selectionSort(arr)));
//        System.out.println(Arrays.toString(insertSort(arr)));
//        System.out.println(Arrays.toString(shellSort(arr)));
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
}
