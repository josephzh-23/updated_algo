//import Heap.Interval
//import kotlinx.coroutines.flow.merge
//import java.util.*
//import kotlin.math.max
//
//
///*
//
//Each employee has a list of
// */
//
//
//// Definition for an Interval.
//
//
///*
//Can use a heap for this here, do not be fooled by the employee
//there it doesn't matter here
// */
//fun main() {
//    var arr = arrayListOf(arrayListOf(Interval(1, 2),
//            Interval(5, 6)), arrayListOf(Interval(1,3)), arrayListOf(Interval(4, 10)))
//    employeeFreeTime(arr)
//}
//fun employeeFreeTime(schedules: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
//
//    var allSechedules = mutableListOf<Interval>()
//    // We will sort this first
//
//    schedules.forEach {
//
//        allSechedules.addAll(it)
//    }
//
//    // Sort arraylist with start values
//    allSechedules.sortBy{it.start}
//
//    var mergedList = mutableListOf<Interval>()
//    var (curStart, curEnd) = Pair(allSechedules[0].start, allSechedules[0].start)
//
//    for(i in 1 until allSechedules.size){
//        val interval = allSechedules[i]
//
//        if(interval.start <= curEnd){
//            // We try to get the latter end here
//            curEnd = Math.max(curEnd, interval.end)
//
//            // In the case that we have [6, 7] > current end
//        }else{
//            mergedList.add(Interval(curStart, curEnd))
//
//            curStart = interval.start
//            curEnd = interval.end
//        }
//    }
//
//    // add the last remaining element
//    // [1, 3], [4, 10]
//    mergedList.add(Interval(curStart, curEnd))
//
//
//    val freeTimeList = mutableListOf<Interval>()
//    for (i in 1 until mergedList.size){
//        /*
//        4 > 3
//        [3, 4]
//         */
//        if(mergedList[i].start > mergedList[i-1].end)
//            freeTimeList.add(Interval(mergedList[i-1].end, mergedList[i].start))
//    }
//    return freeTimeList as ArrayList<Interval>
//
//
//}
