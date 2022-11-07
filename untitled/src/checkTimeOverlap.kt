//
///*
//
//slotsA = [[10, 50], [60, 120], [140, 210]]
//slotsB = [[0,15], [60, 70]]
//dur = 8
//
//teh amount of time they want to meet for
//Output:
//1. [60, 68]
//and you want the earlist time
//2. You want the earliest time they can meet
//
//Constraints:
//are they sorted in anyway? sorted by start time
//
// */
//
//val slotsA = arrayOf(intArrayOf(6, 8),
//        intArrayOf(10, 18),
//        intArrayOf(20, 50),
//        intArrayOf(60, 120),
//        intArrayOf(140, 210))
//
//// The next 2 would be empty here
//val slotsB = arrayOf(intArrayOf(0, 15),
//        intArrayOf(60, 70))
//
//
//fun checkTimeOverlap(list1: Array<IntArray>, list2: Array<IntArray>,
//duration: Int){
//    // loop there are a few cases here
//    for(i in 0 until list2.size.kt){
//        val a = list1[i]
//        val b=  list2[i]
//
//    /*
//    1. a.end < b.start      no overlap here
//    2. b.end < a.start      no overlap here
//    3. there is overlap and overlap >= duration
//    4. there is overlap and the overlap < duration
//     */
//        // Then an overlap as indicated here
//        // 6, 8         0, 15
//        if(a[0] < b[0] || b[1] < a[0]){
//            println("no overlap")
//
//            // an overlap
//        }else(){
//
//        }
//    }
//}
//
//fun Tree.Tree.Top6.main(){
//    checkTimeOverlap(slotsA, slotsB)
//}