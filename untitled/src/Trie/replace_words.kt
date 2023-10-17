import Trie.TrieNode


/*
Input: dictionary = ["cat","bat","rat"],
sentence = "the cattle was rattled by the battery"

Output: "the cat was rat by the bat"
 */
fun main() {
    var l = listOf("cat", "bat", "rat")
    val sentence = "the cattle was rattled by the battery"
    replaceWords(l, sentence)
}
fun replaceWords(roots: List<String>, sentence: String): String {
    val trie = TrieNode()

    // All the roots will be in there
    for (root in roots) {
        var cur: TrieNode = trie

        // Go through each letter in the roo cat
        for (letter in root.toCharArray()) {
            if (cur.children[letter - 'a'] == null)
                cur.children[letter - 'a'] = TrieNode()
            cur = cur.children[letter - 'a']!!
        }
        // Each cur node will have a word
        // c.word = cat

        println("the root is " + root + "with the cur $cur")
        cur.word = root
    }


    val ans = StringBuilder()
    for (word in sentence.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
        if (ans.length > 0) ans.append(" ")
        var cur: TrieNode = trie
        for (letter in word.toCharArray()) {
            if (cur.children[letter - 'a'] == null || cur.word != null) break

            // This is the same as search in trie
            cur = cur.children[letter - 'a']!!
        }
        ans.append(if (cur.word != null) cur.word else word)
    }
    return ans.toString()
}