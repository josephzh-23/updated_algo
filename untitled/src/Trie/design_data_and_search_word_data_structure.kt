package Trie


/*
WHy do we use a trie here but not map as said? It's not efficient for the following

1. if you want to find all keys with a common prefix

2. enumerate a dataset of strings in lexicological order
3. USing map would result in O (N * m) operation

 */

private class WordDictionary {
    var trie: TrieNode = TrieNode()

    // add word in a search here
    // T : o(m) m is the key length
    fun addWord(word: String) {
        var node: TrieNode? = trie
        for (ch in word.toCharArray()) {
            if (!node!!.children.containsKey(ch)) {
                node.children[ch] = TrieNode()
            }
            node = node.children[ch]
        }
        node!!.isEndOfWord = true
    }

    /** Returns if the word is in the node.  */
    fun searchInNode(word: String, node: TrieNode?): Boolean {
        var node = node
        for (i in 0 until word.length) {
            val ch = word[i]
            node = if (!node!!.children.containsKey(ch)) {
                // If the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') {
                    for (x in node.children.keys) {
                        /*
                        If the word we have are
                            s.addWord("bad")
                            s.addWord("dad")
                             s.addWord("mad")
                            s.addWord("pad")
                            if the node is a here-
                         we would have b, d,m, p as children

                         */
                        val child = node.children[x]
                        println("the children are ${node.children.size} and $x")
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true
                        }
                    }
                }
                // If no nodes lead to answer
                // or the current character != '.'
                return false
            } else {
                // If the character is found
                // go down to the next level in trie
                node.children[ch]
            }
        }
        return node!!.isEndOfWord
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.  */
    fun search(word: String?): Boolean {
        return searchInNode(word!!, trie)
    }
}

fun main() {
    var s= WordDictionary()
    s.addWord("bad")
    s.addWord("dad")
    s.addWord("mad")
    s.addWord("pad")
    s.search(".ad")
}














