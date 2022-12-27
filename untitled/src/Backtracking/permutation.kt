package Backtracking


/*
Iterate over each character,
for each char, start to pick 1st char make a permutation
then go back, remove it and then pick the next element
 */

/*
https://www.youtube.com/@nikoo28
nums = [1 2 3]
Output: [[1,2,3],   [1,3,2],   [2,1,3],
[2,3,1],   [3,1,2],   [3,2,1]]
 */
fun main() {
    permute(intArrayOf(1, 2, 3))
}
fun permute(nums: IntArray): List<List<Int>> {
    val resultList: MutableList<List<Int>> = ArrayList()
    backtrack(resultList, ArrayList(), nums)
    println(resultList)
    return resultList
}

private fun backtrack(resultList: MutableList<List<Int>>,
                      tempList: ArrayList<Int>, nums: IntArray) {
    // If we match the length, it is a permutation
    if (tempList.size == nums.size) {
        resultList.add(ArrayList(tempList))
        return
    }
    for (number in nums) {
        // Skip if we get same element
        if (tempList.contains(number)) continue

        // Add the new element
        tempList.add(number)

        // Go back to try other element
        backtrack(resultList, tempList, nums)

        // Remove the element
        tempList.removeAt(tempList.size - 1)
    }
}