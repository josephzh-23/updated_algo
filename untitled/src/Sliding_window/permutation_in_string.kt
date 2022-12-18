package Sliding_window

// Can not sort here will mess up order
// Use brute force approach here
fun checkInclusion(s1: String, s2: String): Boolean {
        // you begin by checking here
    // s1 and s2 problem

    var fre: MutableMap<Char, Int> = HashMap()
    for(c in s1.toCharArray()) {
        fre.put(c, fre.getOrDefault(c, 0) + 1)
    }
    for(c in s2.toCharArray()) {
        if (fre.get(c) != 0) {

        }
    }
}