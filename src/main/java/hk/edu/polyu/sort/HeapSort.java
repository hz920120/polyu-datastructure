package hk.edu.polyu.sort;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-02 10:02:09
 * @declaration heap sort
 * @e-mail hz920120@gmail.com
 */
public class HeapSort {

    /*
    * father's son
    * left : 2 * i + 1
    * right : 2 * i + 2
     * */

    /*
    * node's father :
    * (i - 1) / 2
    * */



    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //turn arr into heap
        for (int i = 0; i < arr.length; i++) { //O(N)
            heapInsert(arr, i);//O(logN)
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {//O(N)
            heapify(arr, 0, heapSize);//O(logN)
            swap(arr, 0, --heapSize);//O(1)
        }

    }
    /**
     * judging whether the number of the index can move up
     * @param arr
     * @param index
     */
    private void heapInsert(int[] arr, int index) {
        //if father of the node is bigger than the node, break the loop
        while (arr [(index - 1) / 2] > arr[index]) {
            //swap father and son
            swap(arr, (index - 1) / 2, index);
        }
    }

    /**
     * judging whether the number of the index can move down
     * @param arr
     * @param index
     * @param heapSize
     */
    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;

        //if the node do not have the left son(of course no right son) and one of the sons is bigger than father ,break the loop
        while (left < heapSize) {

            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }








    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
