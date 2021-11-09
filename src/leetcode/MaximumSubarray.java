package leetcode;

public class MaximumSubarray {
    public static void main (String args []){
        int [] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        printArray(nums1);
        System.out.println(maxSubArray(nums1));
        int [] nums2 = {1};
        printArray(nums2);
        System.out.println(maxSubArray(nums2));
        int [] nums3 = {5,4,-1,7,8};
        printArray(nums3);
        System.out.println(maxSubArray(nums3));
    }
    public static int maxSubArray(int[] nums) {
        int fi_1 = nums[0];
        int max = fi_1;
        int fi = 0;
        for(int i = 1; i < nums.length; i++){
            fi = fi_1 < 0 ? nums[i] :nums[i] + fi_1;
            fi_1 = fi;
            max = fi > max ? fi : max;
        }
        return max;
    }

    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length -1; i++){
            System.out.print(nums[i]+ ", ");
        }
        System.out.println(nums[nums.length-1] + "]");
    }
}
