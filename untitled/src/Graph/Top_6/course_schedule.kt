
// Course schedule is for a directed graph
//https://www.youtube.com/watch?v=CL4NZAoOdpM&t=483s

// This is using the dfs problem
package Graph.Top_6


internal class Course_Schedule3 {
    lateinit var adj: Array<MutableList<Int>>
    lateinit var visited: BooleanArray
    lateinit var explored: BooleanArray
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        adj = Array(numCourses){mutableListOf(numCourses)}

        // Initialize a new list for each node here
        for (i in 0 until numCourses) {
            adj[i] = ArrayList()
        }
        visited = BooleanArray(numCourses)

        /*
        When do you mark explored as true ?

        All it's neighbor has been visited!
        when go from 2 -> 3         visited[3] = true
        explored[3] = true
         */
        explored = BooleanArray(numCourses)

        // [1, 2]   ->    1: [2]
        for (i in prerequisites.indices) {
            adj[prerequisites[i][0]].add(prerequisites[i][1])
        }
        for (i in 0 until numCourses) {
            if (!visited[i]) {
                if (isCyclic(i)) {
                    return false
                }
            }
        }
        return true
    }

    fun isCyclic(node: Int): Boolean {
        visited[node] = true
        for (neigh in adj[node]) {
            if (!visited[neigh]) {
                if (isCyclic(neigh)) {
                    return true
                }
            } else if (!explored[neigh]) {
                println(explored[neigh])
                return true
            }
        }
        explored[node] = true
        return false
    }
}

fun main(){

    val times1 = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
    );
    var c = Course_Schedule3()
    // This is 3 because of the 2 before
    println(c.canFinish(3, times1))

    // And then using this we could have
}