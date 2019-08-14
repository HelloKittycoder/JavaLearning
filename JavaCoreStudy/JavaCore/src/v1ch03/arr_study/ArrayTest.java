package v1ch03.arr_study;

import java.util.Arrays;

/**
 * Created by shucheng on 2018/4/21.
 */
public class ArrayTest {

    public static void main(String[] args) {
        // 数组打印
        /*int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(a));

        int[] b = Arrays.copyOf(a, 2*a.length);
        System.out.println(Arrays.toString(b));*/

        // 数组排序
        /*int randomNum = 0;
        int[] arr = new int[200];
        // 数组排序
        for (int i = 0; i < 200; i++) {
            randomNum = (int) (1001*Math.random()); // [0,1000]之间取值的随机数
            arr[i] = randomNum;
        }
        System.out.printf("%1s %2s","排序前",Arrays.toString(arr));
        System.out.println();
        Arrays.sort(arr);
        System.out.printf("%1s %2s","排序后",Arrays.toString(arr));
        System.out.println();
        int index = Arrays.binarySearch(arr, 60);
        System.out.printf("%1s", index);*/

        // 数组比较
        /*int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5};
        System.out.println(Arrays.equals(a,b));*/

        // 快速打印二维数组
        int[][] a = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(Arrays.deepToString(a));
    }
}
