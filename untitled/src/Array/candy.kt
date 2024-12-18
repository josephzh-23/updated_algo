//package Array
//
//
///*
//
//N children
//ratings
// */
//
//fun candy(ratings:IntArray):Int {
//
//    var numChildren = ratings.size
//
//    var candiesFromLeft = IntArray(numChildren)
//    var candiesFromRight = IntArray(numChildren)
//    candiesFromLeft.fill(1)
//    candiesFromRight.fill(1)
//
//    for(i in 1..(numChildren-1)){
//
//        if(ratings[i-1] < ratings[i]){
//            candiesFromLeft[i] = candiesFromLeft[i-1] + 1
//        }
//    }
//
//    for(i in numChildren-2 downTo 0){
//        if(ratings[i ] > ratings[i + 1]){
//            candiesFromRight[i] = candiesFromRight[i + 1] + 1
//        }
//    }
//    /*
//
//    Then we sum the candies from the left and right of both child
//     */
//
//
//    for(i in candiesFromLeft.indices){
//        val maxi =
//    }
//}
