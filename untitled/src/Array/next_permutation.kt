package Array

/*
This gives you the next permutation here
And then becomes as we said here
 */

/*


So the code will look like here

[1, 3, 5, 4, 2] here

So to work on this we have

1. Finding pivot: Backward traverse
Find first decreasing which is 3 at index 1 since 3 < 5

2. We need to find the smallest number greater than the pivot 3, starting from the end of the array. Traverse: 2 (not greater), 4 (greater, stop here). The successor is 4 at index 3.


3. Swap the pivot and its successor
swap 3 and 4
The array is now: [1, 4, 5, 3, 2].

4. Then reverse the suffix here

Reverse the Suffix:
We reverse the suffix starting right after the pivot's new position (index 1) till the end. The suffix is [5, 3, 2] and its reverse is [2, 3, 5]. The array after reversing the suffix is: [1, 4, 2, 3, 5].
 */
fun nextPermutation(nums: IntArray) {
    var i = nums.size - 2

    // From teh back of the array
    // Find the point where at i nums[i] < nums[i + 1]
    while (i >= 0 && nums[i + 1] <= nums[i]) {
        i--
    }

    /*
     If i >= 0 then find the next biggest element bigger then
        current element
     */
    if (i >= 0) {
        var j = nums.size - 1
        while (nums[j] <= nums[i]) {
            j--
        }
        swap(nums, i, j)
    }
    reverse(nums, i + 1)
    nums.forEach{
        println(it)
    }
}

private fun reverse(nums: IntArray, start: Int) {
    var i = start
    var j = nums.size - 1
    while (i < j) {
        swap(nums, i, j)
        i++
        j--
    }
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

fun main() {
    var arr = intArrayOf(1, 2, 3)

    print(nextPermutation(arr))
}






