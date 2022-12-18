package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class permutation {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, nums, 0);
        return result;

    }

    public void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(toList(nums));
        } else {
            for (int i = start; i < nums.length; i++) {

                // Place the ith integer first in the current
                // implementation
                swap(i, start, nums);
                /*
                Basically here we proceed to genere all permutations which
                start from i-th integer : backtrack(first + 1).
                 */
                // Use next integers to complete the permutations
                backtrack(result, nums, start + 1);

                // Here then we backtrack to the previous index since
                // we need to reverse the swapping done in the current function call
                swap(i, start, nums);
            }
        }
    }

        // convert array to list
    public List<Integer> toList(int[] nums){

        List<Integer> res = new ArrayList<>();
        for(int i: nums){
            res.add(i);
        }
        return res;
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
