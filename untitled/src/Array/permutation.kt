package Array

// Print all permutatino of an array
// https://leetcode.com/problems/permutations/


/*
1  2  3 ->   1  3   2
2  1  3 ->   2   3  1
3  2  1 ->   3   1  2
 */
/*
 1. Iterate over the integers from index first to index n - 1
 2. Place i-th integer first in the permutation, i.e. swap(nums[first], nums[i]).

 3. Proceed to create all permutations
    which starts from i-th integer : backtrack(first + 1).

 4. Now backtrack, i.e. swap(nums[first], nums[i]) back.
 */


// If the first integer to consider
// has index n that means that the current permutation is done.