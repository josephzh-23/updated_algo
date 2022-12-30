

// How to print just [1], [2], [3]
// So we got [1], [], [2], [], [3], []
// Best advices sheet
fun subsets2(nums: IntArray): List<List<Int>>? {
    val resultList: MutableList<List<Int>> = ArrayList()

    // Start backtracking from the beginning
    backtrack(resultList, ArrayList(), nums, 0)
    println(resultList)
    return resultList
}

private fun backtrack(resultSets: MutableList<List<Int>>, tempSet: MutableList<Int>,
                      nums: IntArray, start: Int) {
    if(tempSet.size ==1){
        resultSets.add(ArrayList(tempSet))
        return
    }
//    resultSets.add(ArrayList(tempSet))
    for (i in start until nums.size) {

        // Case of including the number
        tempSet.add(nums[i])

        // Backtrack the new subset
        backtrack(resultSets, tempSet, nums, i + 1)

        // Case of not-including the number
        // Still can't get it to behave the way I want
        tempSet.removeAt(tempSet.size - 1)
        resultSets.add(ArrayList())
    }
}
fun main() {
    var arr = intArrayOf(1, 2, 3)
    subsets2(arr)
}