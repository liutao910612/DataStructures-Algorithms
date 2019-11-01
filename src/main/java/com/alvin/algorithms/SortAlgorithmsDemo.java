package com.alvin.algorithms;

import java.util.Arrays;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author alvinl
 * @date 11/01/19 10:10
 **/
public class SortAlgorithmsDemo {
    int[] arr = {8, 3, 9, 1, 5, 2, 7};
    int size = arr.length;

    public void testBubbleSort() {

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp;
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public void testInsertionSort() {
        for (int i = 0; i < size; i++) {
            int temp = arr[i];

            int leftIndex = i - 1;
            while (leftIndex >= 0 && arr[leftIndex] > temp) {
                arr[leftIndex + 1] = arr[leftIndex];
                leftIndex--;
            }
            arr[leftIndex+1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }




    public static void main(String[] args) {
        SortAlgorithmsDemo sortAlgorithmsDemo = new SortAlgorithmsDemo();
        sortAlgorithmsDemo.testBubbleSort();
        sortAlgorithmsDemo.testInsertionSort();
    }
}
