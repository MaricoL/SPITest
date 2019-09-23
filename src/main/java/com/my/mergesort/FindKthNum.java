package com.my.mergesort;

/**
 * @author mrjimmylin
 * @description O(n) 时间复杂度内求无序数组中的第 K 大元素。
 * @date 2019/9/23 10:51
 */
public class FindKthNum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = findNum(nums, 0, nums.length - 1, 1);

        System.out.println(result);
    }

    private static int findNum(int[] nums, int start, int end, int k) {
        if (k == 0) return 0;
        int p = partition(nums, start, end);
        if (p + 1 == k) {
            return nums[p];
        } else if (k < p + 1) {
            return findNum(nums, start, p - 1, k - 1);
        } else if (k > p + 1) {
            return findNum(nums, p + 1, end, k + 1);
        }
        return 0;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int p = partition(nums, start, end);

        quickSort(nums, start, p - 1);
        quickSort(nums, p + 1, end);

    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
