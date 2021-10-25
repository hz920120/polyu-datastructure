package hk.edu.polyu.sort;

import java.util.Arrays;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-25 00:11:35
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class qs {
    public static int partition(int[] arr,int L,int R){
        if (L > R){
            return -1;
        }
        if (L == R){
            return L;
        }
        int pivot = arr[R];
        System.out.println("pivot : " + pivot);
        // edge of less or equals to
        int lessEqual = L - 1;
        // current index
        int index = L;
        while (index < R){
            if (arr[index] <= arr[R]){
                swap(arr,index,++lessEqual);
            }
            System.out.println("arr : " + Arrays.toString(arr));
            index++;
        }
        // swap
        swap(arr, ++lessEqual, R);
        System.out.println("arr : " + Arrays.toString(arr));
        return lessEqual;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    public static void main(String[] args) {


        int array[] = new int[]{106,107,101,108,111,109,112,115,114,113};
//        int array[] = new int[]{29 ,70 ,85 ,40 ,47 ,26, 13 ,59};
//        System.out.println("arr : " + Arrays.toString(array) );
        quickSort1(array);
    }
}
