package Heap

import Split.m
import java.util.*
import java.util.function.Consumer


/*

There r 2 cases here

The calculated time is > taskCount:  This means that even after scheduling the most frequent tasks with their cooldowns, we are able to accommodate all other tasks within the idle time slots. In this case, the calculated time is the result.

The calculated time <= taskCount. This means that the tasks are diverse enough that we do not need idle time, and the total number of tasks is the minimum time needed to complete them all. In this case, the number of tasks is the result.

Initialize an array freq of size 26 to store the frequency of each task.
Iterate through the tasks array and update the frequency of each task in the freq array.
Create a priority queue pq and insert the frequencies of the tasks into the queue.
Initialize a variable time to keep track of the total time taken.


While the priority queue is not empty, repeat the following steps:
1. Initialize a variable cycle to n + 1, which represents the cooling interval plus one (for the current task).

2. Initialize an empty array store to store frequencies of tasks that still need to be processed.

3. Initialize a variable taskCount to keep track of the number of tasks processed in the current cycle.
4. While cycle is greater than 0 and the priority queue is not empty, repeat the following steps:
Decrement cycle.
Pop the top element (task frequency) from the priority queue.

Store array here is used to restore the heap for the next usage
5.
If the popped frequency is greater than 1, decrement it by 1 and store it in the store array
Increment taskCount as it keeps track of the number of tasks processed in the current cycle.
After processing tasks in the cycle, restore the updated frequencies (stored in the store array) back to the priority queue.
Update the time by adding either taskCount (if the priority queue is empty) or n + 1 (cooling interval) to the total time.
Finally, return the total time.
*/


fun leastInterval(tasks: CharArray, n: Int): Int {
    // Build frequency map
    val freq = IntArray(26)
    for (ch in tasks) {
        freq[ch.code - 'A'.code]++
    }


    // Max heap to store frequencies
    val pq = PriorityQueue(Collections.reverseOrder<Int>())
    for (i in 0..25) {
        if (freq[i] > 0) {
            pq.offer(freq[i])
        }
    }

    var time = 0
    /*
      Remember store will be added back to the heap
      1st iter:
      At first heap will be [3, 3]
      Both of these will be decremented and popped and will become
      [2, 2]
      and then the store will be [2]
      taskCount = 2

      2nd:
      At first heap will be [3]
      and then the store will be [2, 2]
      taskCount = 2
       */
    while (!pq.isEmpty()) {
        var cycle = n + 1
        val store: MutableList<Int> = ArrayList()
        var taskCount = 0
        while (cycle-- > 0 && !pq.isEmpty()) {

            println("the heap here is"+pq)
            val currentFreq = pq.poll()
            if (currentFreq > 1) {

                store.add(currentFreq - 1)
            }
            println("store is"+store)
            taskCount++
        }
        /*


         */
        // Restore updated frequencies to the heap
        // the one stored in the frequency here
        store.forEach(Consumer { e: Int -> pq.offer(e) })
        // Add time for the completed cycle
        time += (if (pq.isEmpty()) taskCount else n + 1)
    }
    return time
}


fun main() {

    var tasks = charArrayOf('A', 'A', 'A', 'B' , 'B', 'B')
    var n = 2;
    println(leastInterval(tasks, n))
}











