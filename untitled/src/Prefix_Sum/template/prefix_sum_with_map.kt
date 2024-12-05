import Graph.dfs_with_return.totalCount

/*


Run the code above here

1 0 1 0 1

i = 0       if the goal is 2 here

cursum = 1 ; totalcount = 0 ; prefixsum = {1 : 1}

And the above makes sense
i = 1
curusm = 1 totalcount = 0  prefixSUm = {1: 2}

i = 2
curusm = 2 totalcount = 1  prefixSUm = {1: 2} {2: 1}

i = 3
curusm = 2 totalcount = 1  prefixSUm = {1: 2} {2: 2}

i = 4
curusm = 3 totalcount = 2  prefixSUm = {1: 2} {2: 2}  {3: 1}

totalCount = totalCount + freq[cursum - goal]
           = 2 + freq[1]
           = 2 + 2
           = 4
// And then the code here would be as above here




This is in reference to the question binary subarray with sum
 */
fun numSubarrayWithSum(nums: IntArray, goal :Int){

     var totalCount = 0
    var cursum = 0

    var freq = mutableMapOf<Int,Int>()

    for (num in nums){

        cursum+= num

        if (cursum== goal){
            totalCount++;
        }

        if(freq.contains(cursum - goal)){
            // THen we have seen this before
            totalCount += freq.getOrDefault(cursum - goal, 0)

        }
        // And then the above would have this effect here right? very good
        freq.put(cursum, freq.getOrDefault(cursum, 0)  + 1)

    }
}
