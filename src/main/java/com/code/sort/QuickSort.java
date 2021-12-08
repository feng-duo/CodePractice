package com.code.sort;

/**
 * 快速排序
 *
 * @author FengDuo
 * @date 2021/12/08 23:08
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr= {7,6,4,9,10,3,5,8,2,1};
        int[] newArr=quickSort(arr,0,arr.length-1);
        for (int i : newArr) {
            System.out.print(i+"\t");
        }
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if(left<right) {
            int index=partition(arr,left,right);
            quickSort(arr,left,index-1);
            quickSort(arr, index+1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
