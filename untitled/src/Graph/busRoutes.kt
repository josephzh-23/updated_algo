package Graph

import java.util.*

fun main() {
    var routes = arrayOf(intArrayOf(1, 2, 7),
    intArrayOf(3, 6, 7))
    var (src, tar) = intArrayOf(1, 6)
    numBusesToDestination(routes, src, tar)
}
fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    val busRoutes: MutableMap<Int, MutableList<Int>> = HashMap()

    /*

    Think of i as bus number associated with a route
    busRoutes:  1 ->  0
                2->   0         7-> 0, 1    (since it appears in both)

     so bus route 7 tied with bus number 0 and 1
     */
     // # of routes : 7
    for (i in routes.indices) {


        // loop thru the routes
        for (j in routes[i].indices) {
            // add route to the bus if it doesn't exist yet

            var busNumbers = ArrayList<Int>()
            busRoutes.putIfAbsent(routes[i][j], busNumbers)
            //record the bus number
            busRoutes[routes[i][j]]!!.add(i)
        }
    }

    val visitedBusNumber = HashSet<Int>()

    // That's the bus stop we are adding here
    val busStops: Queue<Int> = LinkedList()
    var numberOfBuses = 0

    // add the initial stops first
    busStops.add(source)
    while (!busStops.isEmpty()) {
        val size = busStops.size
        var i = 0
        while (i < size) {

            // pull out the first stop
            val stop = busStops.poll()
            if (stop == target) {
                println(numberOfBuses)
                return numberOfBuses
            }

            // busRoutes[1] = 0
            // busRoutes[7] = 0 , 1
            val busNumbers: List<Int> = busRoutes[stop]!!

            // grab each stop in the bus number
            for (number in busNumbers) {

                // add bus number to visited only if it doesn't exist
                // yet
                if (visitedBusNumber.contains(number)) continue
                visitedBusNumber.add(number)
                var j = 0

                // Iter over each route number rows , here would be 3
                // if number = 0
                while (j < routes[number].size) {


                    // add the routes of the bus number to the q
                    // basically add 1, 2, 7
                    busStops.add(routes[number][j])
                    j++
                }
            }
            i++
        }
        numberOfBuses++
    }
    println(numberOfBuses)
    return numberOfBuses
}