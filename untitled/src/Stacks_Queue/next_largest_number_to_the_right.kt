import java.util.*


/*

In this problem we have 2 arrays here s

 nums1 = [4,1,2], nums2 = [1,3,4,2]

 and then we have [-1, 3, -1] here is the final answer here
Step # 1 here

We will create a dictionary called m to map each element in nums2 to its next greater element. This will help in quickly looking up the result for each element in nums1.

Step 2:
Then Stack
get all elements for which we have to find the next greater elements here

If stack not empty:
check top element in the stack if top < v:
    v is the next greater elem for that stack top at the time
    Top from the top and then make v as NGE in our dictionary here


 */
fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    // Use a stack to keep track of the elements for which we want to find the next greater element
    val stack: Deque<Int> = ArrayDeque()
    // Create a map to store the next greater element for each number in nums2
    val nextGreaterMap: MutableMap<Int, Int> = HashMap()


    // Loop through each element in nums2
    for (num in nums2) {
        // While there is an element in the stack and it is smaller than the current number
        while (!stack.isEmpty() && stack.peek() < num) {
            // Pop the element from the stack and put its next greater element (num) in the map
            // So this would be { curElem : the NGE}

            // the above is #1 step here in this procedure as said
            nextGreaterMap[stack.pop()] = num
        }
        // Push the current number onto the stack
        stack.push(num)
    }


    // Initialize the array to store the next greater elements for nums1
    val n = nums1.size
    val result = IntArray(n)


    // Loop through each element in nums1
    for (i in 0 until n) {
        // If nums1[i] has a next greater element in nums2, use it; otherwise, use -1
        result[i] = nextGreaterMap.getOrDefault(nums1[i], -1)
    }
    // Return the result array with the next greater elements for nums1
    return result
}

fun main() {
    val arr = intArrayOf(4, 1, 2)
    val arr2 = intArrayOf(1, 3, 4, 2)
    val arr3 = nextGreaterElement(arr, arr2)
    println("The next greater elements are ")
    for (i in arr3.indices) {
        print(arr3[i].toString() + " ")
    }
}
