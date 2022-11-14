package Dynamic_programming

/*
Notice max sum array we are returning
 */
fun maxSumArray(nums: IntArray): Int {
    var max_so_far = nums[0]
    var res = nums[0]
    // this has to start at 1 as stated before so what you do is
    // start this at 1
    for(i in 1 until nums.size){
        max_so_far = Math.max(nums[i], max_so_far + nums[i])
        res = Math.max(res, max_so_far)
    }
    println(res)
    return res
}

fun main(){
    // output 6: array [4, -1, 2 , 1] has the largest sum = 6
    var intarr = intArrayOf(-2, 1,-3, 4, -1, 2,1, -5, 4)
    maxSumArray(intarr)
}






