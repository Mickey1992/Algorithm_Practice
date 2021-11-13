package leetcode;

import java.util.Arrays;

public class IntersectionofTwoArraysII {
    public static void main (String[] args){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        printArray(intersect2(nums1, nums2));

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        printArray(intersect2(nums3, nums4));


    }

    //不改变原来的数组
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] occurrence = new int [1001];
        for(int i = 0; i < nums1.length; i++){
            occurrence[nums1[i]] = occurrence[nums1[i]] + 1;
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int resultIndex = 0;
        for(int i = 0; i < nums2.length; i++) {
            if(occurrence[nums2[i]] > 0){
                result[resultIndex++] = nums2[i];
                occurrence[nums2[i]] --;
            }
        }
        return Arrays.copyOf(result, resultIndex);
    }

    //改变原来的数组
    public static int[] intersect2(int[] nums1, int[] nums2) {
        int[] occurrence = new int [1001];
        for(int i = 0; i < nums1.length; i++){
            occurrence[nums1[i]] = occurrence[nums1[i]] + 1;
        }

        for(int i = 0; i < nums2.length; i++) {
            if(occurrence[nums2[i]] > 0){
                occurrence[nums2[i]] --;
            } else{
                nums2[i] = -1;
            }
        }
        return Arrays.stream(nums2).filter($ -> $ >= 0).toArray();
    }
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        int[] occurrence = new int [1001];
//        for(int i = 0; i < 1001; i++){
//            occurrence[i] = -1;
//        }
//        for(int i = 0; i < nums1.length; i++){
//            occurrence[nums1[i]] = occurrence[nums1[i]] == -1 ? 1 : occurrence[nums1[i]] + 1;
//        }
//
//        for(int i = 0; i < nums2.length; i++){
//            occurrence[nums2[i]] = occurrence[nums2[i]] - 1;
//        }
//
//        return Arrays.stream(nums1.length < nums2.length ? nums1 : nums2).filter($ -> occurrence[$]==0).toArray();
//    }

    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length -1; i++){
            System.out.print(nums[i]+ ", ");
        }
        System.out.println(nums[nums.length-1] + "]");
    }
}
