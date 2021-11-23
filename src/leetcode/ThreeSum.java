package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSumSolution1(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> calculated = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(!calculated.add(nums[i])) continue;
            result.addAll(twoSum(nums, 0 - nums[i], i));
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int skipIndex){
        Set<Integer> another = new HashSet<> ();
        List<List<Integer>> result = new LinkedList<> ();
        for(int i = skipIndex + 1; i < nums.length; i++){
            if(!another.contains(target-nums[i])) {
                another.add(nums[i]);
                continue;
            }
            List<Integer> subResult = new ArrayList<>();
            subResult.add(nums[skipIndex]);
            subResult.add(nums[i]);
            subResult.add(target-nums[i]);
            Collections.sort(subResult);
            result.add(subResult);
        }
        return result;
    }

    public List<List<Integer>> threeSumSolution2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1, k = nums.length - 1; j < k;){
                int threeSum = nums[i] + nums[j] + nums[k];
                if( threeSum == 0 ){
                    if(!(j > i+1 && nums[j] == nums[j-1])){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                }else if(threeSum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
