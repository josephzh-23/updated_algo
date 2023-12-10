import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*

TC: 2^n + n^2 (split whether to include/exclude, n^2 :
Basically the' word catsanddog -> sanddog -> dog ->  " "

dfs + memo here
 */
internal class Solution123 {
    var wordDict: Set<String>? = null
    /*
    Used to memorize the results here
     */
    var cache: MutableMap<String, List<String>?> = HashMap()

    fun wordBreak(s: String, wordDict: List<String>?): List<String>? {
        this.wordDict = HashSet(wordDict)
        return DFS(s)
    }

    private fun DFS(s: String): List<String>? {
        if (cache.containsKey(s)) return cache[s]
        val res: LinkedList<String> = LinkedList()
        if (s.isEmpty()) {
            res.add("")
            return res
        }
        for (word in wordDict!!) {
            if (s.startsWith(word)) {

                /*
                 Substring takes in the start index as said, so this can be split into
                 cat sanddog
                 */
                val sublist = DFS(s.substring(word.length))
                /*
                Remember if empty we can't add anything as said
                 */
                for (sub in sublist!!) res.add(word + (if (sub.isEmpty()) "" else " ") + sub)
            }
        }
        cache[s] = res
        return res
    }
}