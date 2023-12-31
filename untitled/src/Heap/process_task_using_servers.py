
"""
As long as there r free servers q not empty,
task in front -> free server with smallest weight
        if tie -> assgined to a free server with smallest index

    servers and tasks

    A server assigned task j at second[t] will be free again at t + tasks[j]

    Build an array ans of length m, and[j] = index of the server jth task assigned to
"""
from queue import PriorityQueue

from Python_basics.max_heap import MaxHeap

"""

server[i]
tasks[i]

We use two heaps, one is for free servers, one is for used server.

1. Free server heap is sorted based on weight and index.
2. Used server heap is sorted on available time.

Every time, we first pop from used heap and add to free server heap if
the available time is smaller or equal to current task time.
If the free server is empty, then we use the used server with smallest available time.
"""

def assignTasks(servers, tasks):
    """
    //since if there are multiple tasks that need to be assigned, we need to assign in  the order of index
    //so we can go through tasks from left to right
    //and ask what could be the server for this task
        //For which server it can be assigned, it is determined by which servers are avaiable
    //we just need to choose from the servers that are available with smallest weight
    //Like in priorityQueue

       //So if we have a group of servers with their own next available time
        //if next avaibable time <= the execution time of the task,
        we need to choose the server with smallest weight
        //can we have 2 PQ, one is sorted by weight and index, this is currently avaiable pq
        //one is sorted by available time, this is currently used server pq
    """

def answer(servers, tasks):

    # Free server is based on sorted wegith and index here
    freeservers = MaxHeap()

    #used servers are sorted based on available times
    usedservers = MaxHeap()
    n = len(servers)
    m = len(tasks)
    for i in range(n):
        # add the [weight, index, available times]
        freeservers.add([servers[i], i, 0])

    res = [0] * m

    # for each task it will have time
    for i in range(m):
        #the time it takes to process this taks here
        t = tasks[i]

        """
        Every time, we first pop from used heap and add to free server heap
        if the available time is smaller or equal to current task time.
        If the free server is empty, then we use the used server with smallest available time.

        So now you have servers[i] : weight of the server
        tasks[j] is the time needed to process the jth task in seconds
        """
        # the time at the top < i
        while usedservers and usedservers.top()[2] <= i:
            freeservers.add(usedservers.pop())


        #if no free servers now, find the used servers with smallest available times
        if not freeservers:
            cur = usedservers.pop()
            res[i] = cur[1]
            cur[2] +=t
        # for each task we have tim
        #there is free servers here
        else:
            cur = freeservers.pop()
            res[i] = cur[1]
            cur[2] = i + t
            usedservers.add(cur)

    return res















