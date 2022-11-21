package Graph.Top_6


/*
OC: O(V+ E)     v vertex Edge: number of edges
Check the notes on topological sorting
this follows the khan's algorithm
 */

internal class Solution13 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        // <node, # of incoming edges>
        val table = IntArray(numCourses)
        for (courses in prerequisites) {

            // [1, 0]       0 would be the prereq here
            val curCourse = courses[0]
            table[curCourse]++
        }
        // The set that contains node with no edges
        val hs: MutableSet<Int> = HashSet()


        //find the element that has no incoming edges and then add to set
        for (i in table.indices) {
            if (table[i] == 0) {
                hs.add(i)
            }
        }
        //If the set is empty that means we have cyclic graph
        if (hs.isEmpty() == true) {
            return false
        }

        // Continue top sort if non empty, remove elem from hashset
        while (hs.isEmpty() == false) {
            val it: Iterator<Int> = hs.iterator()
            val element = it.next()


            //Remove edges that the current element has
            for (course in prerequisites.indices) {

                //check to see if element's prerequisite and the current course
                val preQ = prerequisites[course][1]

                //We found a connection between prequisite and current course
                if (preQ == element) {
                    val curCourse = prerequisites[course][0]

                    //remove the incoming edges of this current course
                    table[curCourse]--
                    // if no more incoming edges
                    if (table[curCourse] == 0) {
                        hs.add(curCourse)
                    }
                }
            }
            // Then rmv it
            hs.remove(element)
        }
        //check if there is any elem that has incoming edges
        // if there is still edge -> cycle found
        for (course in table) {
            if (course > 0) return false
        }
        return true
    }
}