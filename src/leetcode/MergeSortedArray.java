package leetcode;

public class MergeSortedArray {
    public static void main(String args[]){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        printArray(nums1);

        int[] nums3 = {1};
        int[] nums4 = {};
        merge(nums3, 1, nums4, 0);
        printArray(nums3);

        int[] nums5 = {0};
        int[] nums6 = {1};
        merge(nums5, 0, nums6, 1);
        printArray(nums5);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int sorted = m+n;
        int cur1 = m-1;
        int cur2 = n-1;

        while(sorted > 0 ){
            if(cur1 < 0){
                nums1[--sorted] = nums2[cur2--];
            }
            else if(cur2 < 0){
                nums1[--sorted] = nums1[cur1--];
            }
            else if(nums1[cur1] >= nums2[cur2]){
                nums1[--sorted] = nums1[cur1--];
            }else{
                nums1[--sorted] = nums2[cur2--];
            }
        }
    }

    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length -1; i++){
            System.out.print(nums[i]+ ", ");
        }
        System.out.println(nums[nums.length-1] + "]");
    }
}
