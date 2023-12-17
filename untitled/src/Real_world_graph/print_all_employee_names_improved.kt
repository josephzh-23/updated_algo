package Real_world_graph


// Input:
// Employee ID, Manager ID, Employee Name

// There is a trick to this problem because 8 -> 8
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

// Better to use arrayList< arrayList for this >
fun solution14(ids: List<Pair<Int, Int>>, employeeNames: Map<Int, String>) {

    var managerToEmployees = Array<MutableList<Int>>(ids.size + 2) { mutableListOf() }
    for (element in ids) {
        val id = element
        val employeeId = id.first
        val managerId = id.second
        println(" manager and employee ids are $employeeId and $managerId")
        managerToEmployees[managerId].add(employeeId)

    }
    dfs2(managerToEmployees, ids[0].first, employeeNames)

}

fun dfs2(adj: Array<MutableList<Int>>, managerId: Int, employeeNames: Map<Int, String>) {
    for (employeeId in adj[managerId]) {
        println("${employeeNames[employeeId]}")
        dfs2(adj, employeeId, employeeNames)
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
    solution14(list, employeeNames)
}
