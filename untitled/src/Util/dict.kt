
import java.util.HashMap


fun main() {
    val capitalCities: HashMap<String, String> = HashMap<String, String>()

    // The following a  { 1: [1, 2] } as discussed      very good for ad
    // adjlist problem      "no interface no constructor error"
    val graph: MutableMap<Int, MutableList<IntArray>> = HashMap()

    // Add keys and values (Country, City)

    // Add keys and values (Country, City)
    capitalCities.put("England", "London")
    capitalCities.put("Germany", "Berlin")

    capitalCities.get("England")
    capitalCities.remove("England")
    println(capitalCities)

    capitalCities

    // to loop thru the kes here
    for (i in capitalCities.keys) {
        println(i)
    }

    for (i in capitalCities.values){
        println(i)
    }

    for (i in capitalCities.entries){
        println(i)
    }

    // update dictionary
}
