package String

import java.util.Arrays.sort

/*

Here we try to solve this using sorting here and quite useful as well

- be a permutation of another string here
 */
fun checkInclusion3(s1: String, s2: String): Boolean {

    // We get this back to a strring here and then next we have the code
    var s1 = sort(s1.toCharArray()).toString()

    for(i in 0 until s2.length - s1.length){

        // At any point if we find sth like above this string will then be ok
        if(s1.equals(s2.substring(i, i + s1.length))){
            return true

        }

    }
    return false


}
/*
The tc here will then be
O((l2 - l1) * l1 log l1)


 */
