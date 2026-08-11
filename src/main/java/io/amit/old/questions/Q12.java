package io.amit.old.questions;

public class Q12 {
    public static void main(String[] args) {
        Integer nums[] = new Integer[] {10, 20, 30, 40, 50, 60, 70};

        Integer target = 20;

        System.out.println("result "+binarySearch(nums, target));

    }

    private static Integer binarySearch(Integer nums[], Integer target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                right = mid-1;
            }
            if(target > nums[mid]) {
                left = mid+1;
            }

        }
        return -1;
    }
}
