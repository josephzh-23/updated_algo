package Real_world_graph

import Util.printList


// So this can be used by everyone here without any exception here
var wordSet = mutableSetOf<String>()
var res = mutableListOf<String>()

/*
Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 */


/*
There is also a way to do this with memoization here but did not touch on that here

 https://leetcode.com/problems/concatenated-words/description/
 */
fun main() {
    var words = listOf("cat", "cats", "catsdogcats", "dog", "dogcatsdog",
            "hippopatmuses", "rat")
    printList(findAllConcatenatedWords(words))
}

fun findAllConcatenatedWords(words: List<String>): List<String> {
    wordSet.addAll(words)
    for (w in words) {
        if (dfs(w)) {
            res.add(w)
        }
    }
    return res
}

fun dfs(word: String): Boolean {

    for (i in 1 until word.length) {
        val prefix = word.substring(i)
        val suffix = word.substring(i, word.length)
        if ((wordSet.contains(prefix) && wordSet.contains(suffix)) || (wordSet.contains(prefix)
                        && dfs(suffix))) {
            return true
        }
    }
    return false
}