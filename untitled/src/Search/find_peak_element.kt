package Search

// Finding the peak elements here

// Finding the peak elements here

/*
SO we go inside to check if a peak: when it's > l

You will notice the 2 trends down here:
l < mid < r           l = mid + 1           this is how we would then se it
l > mid > r            r= mid -1
 */

// [1,2,1,3,5,6,4]
/*
Can either return index num 1 where peak elem = 2, or idx 5 where elem is 6.
 */
fun main() {

}

// Have to use below for this the binary search here
fun findPeakElem(nums: IntArray):Int{

    var (l, r)  =Pair(0, nums.size - 1)
    while(l < r){

        val mid = l + (r-l ) /2
        if(nums[mid] < nums[mid + 1]  ){
            l = mid + 1
        }else {
            r= mid
        }
    }
    return l
}
















