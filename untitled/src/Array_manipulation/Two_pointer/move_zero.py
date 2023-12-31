# move zeros leetcode


"""
    Using the 2 pointer approach, the fast pter : does the job of processing element
Slow pointer:
if we see non-zero, record as last found non-zero element,
Fast pointer:
"""


"""
void moveZeroes(vector<int>& nums) {
    int lastNonZeroFoundAt = 0;
    // If the current element is not 0, then we need to
    // append it just in front of last non 0 element we found.
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] != 0) {
            nums[lastNonZeroFoundAt++] = nums[i];
        }
    }
    
 	// After we have finished processing new elements,
 	// all the non-zero elements are already at beginning of array.
 	// We just need to fill remaining array with 0's.
    for (int i = lastNonZeroFoundAt; i < nums.size(); i++) {
        nums[i] = 0;
    }
}


"""