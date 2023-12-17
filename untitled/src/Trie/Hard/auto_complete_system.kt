//import java.util.*
//
//
//internal class TrieNode23 {
//    var children: MutableMap<Char, TrieNode23> = HashMap()
//    var sentences: MutableMap<String, Int> = HashMap()
//
//
//}
//
//private class AutocompleteSystem(sentences: Array<String>, times: IntArray) {
//    var root: TrieNode23
//    var currNode: TrieNode23
//
//    var dead: TrieNode23
//
//    // This is sort of like a sentence builder here and is therefore very useful here
//
//    //
//    var currSentence: StringBuilder
//
//    init {
//        root = TrieNode23()
//        for (i in sentences.indices) {
//            addToTrie(sentences[i], times[i])
//        }
//        currSentence = StringBuilder()
//        currNode = root
//        dead = TrieNode23()
//    }
//
//    fun input(c: Char): List<String> {
//        /*
//        1. c == # have finished typeing current sentence. add currSentence as a string to the trie using the addToTrie function
//        reset our class variables here, reset the class variable for next sentence here
//        - empty cursentence
//                - curNode = root    return an empty list
//
//        */
//        if (c == '#') {
//            addToTrie(currSentence.toString(), 1)
//            currSentence.setLength(0)
//            currNode = root
//            return ArrayList()
//        }
//
//        // Part of case 2
//        currSentence.append(c)
//
//        /*
//         Case 3
//            case 3 here if c!= # and
//
//     but c is not a child of currNode:
//     there are no existing sentences that have the current sentence we are typing as a prefix.
//      We just need to add c to currSentence and return an empty list.
//         */
//        if (!currNode.children.containsKey(c)) {
//            currNode = dead
//            return ArrayList()
//        }
//
//        /*
//            2.
//    c != '#', and c is a child of currNode: there are some existing sentences that have the current sentence we are typing as a prefix.
//    First, let's add c to currSentence.
//    Next, walk to the child node by doing currNode = currNode.children[c].
//    Now, fetch the sentences that have the current sentence as a prefix -
//    we store them in the hash map currNode.sentences with the mapping sentence: count.
//    Finally, sort these sentences according to their count,
//    and return the top 3 sentences according to the criteria in the problem description.
//
//    Then we can sort
//
//         */
//        currNode = currNode.children[c]!!
//        val sentences: List<String> = ArrayList<String>(currNode.sentences.keys)
//        Collections.sort<String>(sentences) { a: String, b: String? ->
//            val hotA = currNode.sentences[a]
//            val hotB = currNode.sentences[b]
//
//            // The hotness is the same
//            if (hotA == hotB) {
//                return@sort a.compareTo(b!!)
//            }
//            hotB!! - hotA!!
//        }
//        val ans: MutableList<String> = ArrayList()
//        for (i in 0 until Math.min(3, sentences.size)) {
//            ans.add(sentences[i])
//        }
//        return ans
//    }
//
//    private fun addToTrie(sentence: String, count: Int) {
//        var node = root
//        for (c in sentence.toCharArray()) {
//            if (!node.children.containsKey(c)) {
//                node.children.put(c, TrieNode())
//            }
//            node = node.children[c.toInt()]!!
//            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + count)
//        }
//    }
//}