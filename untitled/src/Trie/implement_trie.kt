package Trie


class TrieNode {
//    var children = arrayOfNulls<TrieNode>(ALPHABET_SIZE)
    var children = mutableMapOf<Char, TrieNode>()
    // isEndOfWord is true if the node
    // represents end of a word
    var isEndOfWord = false
}

class Tries {

    // this is the curnode
    private val root: TrieNode

    /** Initialize your data structure here.  */
    init {
        root = TrieNode()
    }

    /** Inserts a word into the trie.  */
    fun insert(word: String) {

        // Same as a binary tree
        var curNode: TrieNode? = root
        val arr = word.toCharArray()
        for (curChar in arr) {

            if (curNode!!.children.containsKey(curChar)) {
                curNode.children[curChar] = TrieNode()
            }

            // Moving down the chain inside the tree
            curNode = curNode.children[curChar]
        }
        curNode!!.isEndOfWord = true
    }

    /** Returns if the word is in the trie.  */
    fun search(word: String): Boolean {
        var curNode: TrieNode? = root
        val arr = word.toCharArray()
        for (curChar in arr) {

            if (curNode!!.children.containsKey(curChar)) {
                return false
            }
            curNode = curNode.children[curChar]
        }
        return curNode!!.isEndOfWord
    }

    /** Returns if there is any word in the trie that starts with the given prefix.  */
    fun startsWith(prefix: String): Boolean {
        var curNode: TrieNode? = root
        val arr = prefix.toCharArray()
        for (curChar in arr) {

            if (curNode!!.children.containsKey(curChar)) {
                return false
            }
            curNode = curNode.children[curChar]
        }
        return true
    }
}

fun main() {
    var s = Tries()
    s.insert("joseph")
    println(s.search("josep"))
}