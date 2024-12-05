package String.Sliding_window

/*
Just using the map here
 */

fun main() {
    var (s1, s2)= arrayOf("ab", "eidbaooo")
    println(permutationInString(s1, s2))
}
fun permutationInString(s1: String, s2: String): Boolean {
    // contains the character of s1 in a map
    // And then we check each c in s2

    var ans = false
    var m = mutableMapOf<Char, Int>()

    for(c1 in s1.toCharArray()) {
        m[c1] = m.getOrDefault(c1, 0) + 1

    }
    var found = false
    var i = 0
    while(i < s2.length) {

        var char = s2[i]
        if (m.containsKey(char)) {
            found = true
            m[char] = m.getOrDefault(char, 0) -1
        }
        println("map size here is"+ m)

        while(found) {

            i++
            char = s2[i]
            println("here character is $char")
            if (i >= s2.length -1 ){
                break
            }
            if(s2[i] == char){
                m[char] = m.getOrDefault(char, 0) -1

            }else{
                break
            }


            if(checkIfMapEMpty(m)){
                ans = true
                return ans
            }

//            println("map size here is"+ m)


        }
        i++
    }
    return ans
}

fun checkIfMapEMpty(map: MutableMap<Char, Int>): Boolean {
    for(c1 in map.values){
        if(c1 != 0){
            return false
        }
    }
    return true
}
