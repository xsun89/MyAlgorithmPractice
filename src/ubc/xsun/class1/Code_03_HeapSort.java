package ubc.xsun.class1;

import java.util.Arrays;

public class Code_03_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

    }

    public static void heapify(int[] arr, int index, int size) {
        int l = index * 2 + 1;
        if(l >= size) {
             return;
        }

        int largest = ((l + 1) < size && arr[l + 1] > arr[l]) ? l + 1 : l;
        largest = arr[largest] > arr[index] ? largest : index;
        if (largest == index) {
            return;
        }

        swap(arr, largest, index);
        heapify(arr, largest, size);
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;


    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        //int[] arr = {-4, 74, -36, 38, 63, 41, -2, -23, -46, 16, -13, 84, -24, 6, -71, -1, 0, 45, -4, 9, 70, -50, 73, 28, 15};
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
