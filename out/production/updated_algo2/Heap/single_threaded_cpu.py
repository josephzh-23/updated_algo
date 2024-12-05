

'''
tasks[i] = [enqueueTime, processtime]
If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time.
 If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.

'''
import heapq
from typing import List, Tuple

from Python_basics.max_heap import MaxHeap
from Two_array.find_difference_of_two_array import size


def singleThreaded(tasks):
    """
    current time = which tasks available for the CPU
    sort all available tasks in increasing order of processing time

    cur time will increase by the processing time of task
    the key:
    after increasing current time, more tasks will become available
    Instead of adding all tasks to the list again, sort the list in
    increasing order of processing time
   """

    # super important here
    # need a current time here
    # Will store the [process time, origninal index]
    nexttask: List[Tuple[int, int]] = []

  # array to store the order in which the CPU will process the tasks.
    taskProcessingOrder = []

    # Store task enqueue time, processing time, index.
    sortedtasks = [(enqueue, process, idx) for idx, (enqueue, process) in enumerate(tasks)]

    sortedtasks.sort()  #sort on the basis of start time
    curtime = 0

    #store the task index currently
    taskindex = 0

    #stop when no tasks left in array
    while taskindex < len(tasks) or nexttask:
        # check if the enqueue time of the next task is greater then cur time
        if not nexttask and curtime < sortedtasks[taskindex][0]:
            #if yes, then update curtime to next task's cur time
            curtime += sortedtasks[taskindex][0]


        # Push all the tasks whose enqueueTime <= currtTime into the heap.
        # this is all task whose starting time < current time
        # this is the meat of the problem
        while taskindex < len(sortedtasks) and curtime >= sortedtasks[taskindex][0]:
            _, processtime, originalindex = sortedtasks[taskindex]
            heapq.heappush(nexttask, (processtime, originalindex))
            taskindex+=1

        # here complete this task and increment time
        processtime, index = heapq.heappop(nexttask)

        curtime += processtime
        taskProcessingOrder.append(index)

    return taskProcessingOrder







