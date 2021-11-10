package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main (String args[]){
        int[] nums1 = {1,2,3,1};
        System.out.println(containsDuplicate1(nums1));
        System.out.println(containsDuplicate2(nums1));
        int[] nums2 = {1,2,3,4};
        System.out.println(containsDuplicate1(nums2));
        System.out.println(containsDuplicate2(nums2));
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate1(nums3));
        System.out.println(containsDuplicate2(nums3));
    }
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int before = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (before == nums[i]) return true;
            before = nums[i];
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> occurence = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if (occurence.contains(nums[i])) return true;
            occurence.add(nums[i]);
        }
        return false;
    }
}
