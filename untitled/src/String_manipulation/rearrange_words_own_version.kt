package String_manipulation

import Util.maxheap
import java.util.*
import kotlin.collections.HashMap

// brute force approach using q
fun arrangeWords(text: String): String {

    // <Word, count>
    var dict = HashMap<String, Int>()
    var string = "joseph sdfs"
    var words = string.split(" ")
    words.forEach{word->
            for (ch in word){
                dict.put(word, dict.getOrDefault(word, 0)+1)
            }
    }

    var maxH: Queue<String> = PriorityQueue{n1: String, n2: String-> dict[n1]!! - dict[n2]!!}
    var s = StringBuilder()
    for(n in dict.keys){
        maxH.add(n)
    }

    while(!maxH.isEmpty()){
        s.append(maxH.poll())

    }

    return s.toString().also{println(it)}

}

fun main() {
   arrangeWords("Is cool leetcode")
}

