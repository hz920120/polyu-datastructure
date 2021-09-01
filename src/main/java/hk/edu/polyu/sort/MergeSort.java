package hk.edu.polyu.sort;

import java.util.Arrays;

/**
 * @author HUANG Zuo
 * @version create_time：2021-08-31 13:36:38
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class MergeSort {

    //分治法
    public int[] sortArray(int[] nums) {
        process(nums, 0, nums.length-1);
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {-2,3,-5};
        final MergeSort mergeSort = new MergeSort();
        mergeSort.sortArray(test);
    }
    //处理逻辑

    private static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        //cut the array into 2 arrays of equal size, find the middle point
        int middle = left + ((right - left) >> 1);
        //proccess left array
        process(arr, left, middle);
        //process right array
        process(arr, middle + 1, right);
        //merge two arrays into a sorted array
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        //create a temporary array which can store sorted array temporarily
        int[] temp = new int[right - left + 1];
        int i = 0;
        //create tow pointers
        int p1 = left;
        int p2 = middle + 1;

        //add lower number into temp, and move the corresponding pointer
        while (p1 <= middle && (p2 <= right)) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //p2 is out of bounds
        while (p1 <= middle) {
            temp[i++] = arr[p1++];
        }

        //p1 is out of bounds
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }

        //merge temp[left,right] into arr[0,left,right,N]
        for (int j = 0; j < temp.length; j++) {
            arr[left++] = temp[j];
        }
    }
}
