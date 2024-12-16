package Journal

/*

We have encountered so far (middle)

and a num > mid
and another num < mid

Give this a dry run here


1 2 3 4 5
1st iter

smallest = 1
mid = infinity

2nd iter
2 > smallest    but < mid
mid = 2

3rd iter
elem = 3        > mid and > smallest

And then we have found sth here that works for our favor and that wors

great news!! and we did it!
 */


fun increasingTriplet(nums: IntArray): Boolean {
    var smallest = Int.MAX_VALUE
    var middle = Int.MAX_VALUE

    for (num in nums) {
        if (num > middle) {
            return true
        }

        if (num <= smallest) {
            smallest = num
        } else {
            middle = num
        }
    }

    return false
}

