package Real_world_graph

// Input:
// Employee ID, Manager ID, Employee Name
// 8, 8, "Alice"
// 2, 8, "Bob"
// 3, 2, "Emp3"
// 4, 3, "Emp4"
// 5, 4, "Emp5"
// 6, 3, "Emp6"
// 7, 8, "Emp7"


// Output:
// Alice
//   Bob
//     Emp3
//       Emp4
//         Emp5
//       Emp6
//   Emp7


// 8 -> "Alice"
fun solution(ids: List<Pair<Int, Int>>, employeeNames: Map<Int, String>) {

    var managerToEmployees = mutableMapOf<Int, MutableList<Int>>()
    for (element in ids) {
        val id = element
        val employeeId = id.first
        val managerId = id.second
        if (managerToEmployees[managerId] == null) {
            managerToEmployees.put(managerId, mutableListOf())
        }
        managerToEmployees[managerId]?.add(employeeId)


    }
    var size = employeeNames.size
    var visited = BooleanArray(size + 2)



    dfs(managerToEmployees, visited, ids[0].first, employeeNames)

}

fun dfs(adj: Map<Int, MutableList<Int>>, isVisited: BooleanArray,
        managerId: Int, employeeNames: Map<Int, String>) {
    if (isVisited[managerId]) {
        return
    }
    isVisited[managerId] = true
    adj[managerId]?.run {
        forEach { id ->
            println("${employeeNames[id]}")
            dfs(adj, isVisited, id, employeeNames)
        }
    }
}

fun main(args: Array<String>) {

    // Input:
// Employee ID, Manager ID, Employee Name
// 8, 8, "Alice"
// 2, 8, "Bob"
// 3, 2, "Emp3"
// 4, 3, "Emp4"
// 5, 4, "Emp5"
// 6, 3, "Emp6"
// 7, 8, "Emp7"
    var list = listOf(Pair(8, 8), Pair(2, 8), Pair(3, 2), Pair(4, 3),
            Pair(5, 4), Pair(6, 3), Pair(7, 8))
    var employeeNames = mapOf(8 to "Alice", 2 to "Bob", 3 to "Emp3",
            4 to "Emp4", 5 to "Emp5", 6 to "Emp6", 7 to "Emp7")
    solution(list, employeeNames)
}
