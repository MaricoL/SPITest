package com.my.mergesort;

import java.util.Arrays;

/**
 * @author mrjimmylin
 * @description 归并排序
 * @date 2019/9/23 8:28
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));

    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int i= 0;
        while (p1 <= mid && p2 <= end) {
            temp[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= end) {
            temp[i++] = nums[p2++];
        }

        for (i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }

    }

}
