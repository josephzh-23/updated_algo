fun subsets(nums: IntArray): List<List<Int>>? {
    val resultList: MutableList<List<Int>> = ArrayList()

    // Start backtracking from the beginning
    backtrack(resultList, ArrayList(), nums, 0)
    println(resultList)
    return resultList
}

private fun backtrack(resultSets: MutableList<List<Int>>, tempSet: MutableList<Int>,
                      nums: IntArray, start: Int) {
    // Add the set to result set
    resultSets.add(ArrayList(tempSet))
    for (i in start until nums.size) {

        // Case of including the number
        tempSet.add(nums[i])

        // Backtrack the new subset
        backtrack(resultSets, tempSet, nums, i + 1)

        // Case of not-including the number
        tempSet.removeAt(tempSet.size - 1)
    }
}
fun main() {
    var arr = intArrayOf(1, 2, 3)
    subsets(arr)
}