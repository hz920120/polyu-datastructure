package hk.edu.polyu.sort;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-01 15:18:10
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class HollandFlag {

    public void hollandFlag(int[] arr, int left, int right, int num) {

        if (left == right) {
            return;
        }

        //create three pointers
        int PL = left - 1;
        int P = left;
        int PR = right + 1;

        while (P < PR) {
            //1.arr[left] < num, swap(P,PL+1) ,P++, PL++
            if (arr[P] < num) {
                swap(arr, P++, ++PL);
            } else if (arr[P] == num) {//2.arr[left] == num, P++
                P++;
            } else {//3.arr[left] > num, swap(P,PR-1), PR--
                swap(arr, P, --PR);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        final HollandFlag hollandFlag = new HollandFlag();
        int[] arr = new int[]{3,5,6,9,2,1,5,4};
        hollandFlag.hollandFlag(arr,0, arr.length - 1, 5);
    }
}
