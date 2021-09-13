package hk.edu.polyu.sort;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-13 14:22:57
 * @declaration 快排3.0
 * @e-mail hz920120@gmail.com
 */
public class QuickSort3A {

    public static void qs3 (int[] arr, int L, int R) {
        if (L < R) {
            if (R - L < 2) {
                swap(arr, L, R);
            } else {
                int ranIndex = L + (int) (Math.random() * (R - L + 1));
                swap(arr, ranIndex, R);

                int[] res = partition(arr, L, R);
                qs3(arr, L, res[0] - 1);
                qs3(arr, res[1] + 1, R);
            }
        }
    }

    /**
     * 左侧为 < R，右侧为 > R ，中间为 = R，返回中间部分的左右index
     */
    private static int[] partition(int[] arr, int L, int R) {

        int P = L;
        int right = R;
        int stan = arr[right];
        while (P < R) {
            if (arr[P] > stan) {
                swap(arr, P,  --R);
            } else if (arr[P] < stan) {
                swap(arr, P++, L++);
            } else {
                P++;
            }
        }
        swap(arr, right, R);
        return new int[] {L, R};
    }

    public static void swap (int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        qs3(arr,0, arr.length - 1);
        System.out.println(1);
    }

}
