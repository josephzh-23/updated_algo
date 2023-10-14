package String//package Sliding_window
//
//import java.lang.Math.abs
//import java.util.*
//
//// Given an integer array nums and an integer k, return true if there are two distinct indices i and
//// j in the array such that nums[i] == nums[j]
//
//// 1 2 3 1  k =3
//fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
//
//    Arrays.sort(nums)
//    var isSame = false
//    var i = 0
//    var j = 0
//    for(i in nums.indices){
//        // 2 distinct indices i and j
//        if(nums[i] == nums[j] && abs(i-j) <k){
//                return true
//        }else{
//            return false
//        }
//    }
//}
//
//
//
//
//
//
//
