package Coding_Challenges

import java.util.*


// Look for begin word

// Look for endword

    /*At each point check if it
    1. can look at each word and figure out the diff between 2 words

     2. Want to find the shortest path from beginning to the end of the
     word, each node differs by 1 letter

     3. "Hit" could be connected to any word in the list as long as they differ
     by 1

     4. Build an adjacency list with the word "hit" -> [hot, cot...]
     like in teh approach given before

     But if you create that, total SC: O(n^2 *m) n for each word
     m for the # of rletter of the word

     Constraints: len(w) < 10       len(list) < 5000

     Can change this to n* m2, (m is bigger, so why we use it)
     */


    /*
    1. For any word, most 1 char diff, Change hot -> *ot
        can also be h*t
          ho*       ->      these are the 3 patterns that people can
          look into

          2. dot -> *ot     dot     do*

          For the words, hot and dot, the 1st 2 letters of word exactly the sam
          *ot, interesting

          2. For each list for each *ot, [hot, dot, ....] will be in the list

          So if we want to find all neighbors of hot, find all neighbors of hot
          hit -> fits too
          Remember hot -> can have neighbor     -> *ot
          h*t   ho*

          Go thru each word -> n
          thru each char    -> m        possible diff pattern


          For shortest path : do a bfs search here
     */


// The solution by tech dose
    fun wordladder(beginWord: String, endWord: String, wordList: Array<String?>): Int {
        val myset: MutableSet<String> = HashSet<String>()


        var isPresent = false //Checks if endWord is present in Dict

        //Insert all words from Dict in myset
        for (word in wordList) {

            // This means?
            if (endWord.compareTo(word!!) == 0) isPresent = true
            myset.add(word) //Insert word in Dict
        }
        if (isPresent == false) //endWord is not present in Dict
            return 0

    // Push the begin word
        val q: Queue<String> = LinkedList()
        q.add(beginWord)

    // The level of bfs we are at
        var depth = 0
        while (!q.isEmpty()) {
            depth += 1

            var lsize = q.size
//No of elements at a level, or simply just the number of words here

            while (lsize-- > 0) {

                // Process the current word
                // Exmaple would be hot, dot
                val curr = q.poll()

                /*
                 Check for all possible characters
                 temp1  "ait" -> "bit" - "cit"    and so on
                 */
                for (i in 0 until curr.length)  //For each index
                {
                    // To change a string cvrt to strinb builder first
                    val temp1 = StringBuilder(curr)
                    var c = 'a'

                    /*
                     Basically this algo will loop thru all the
                letters starting at 'a',

                     */
                    while (c <= 'z') {
                        temp1.setCharAt(i, c)
                        val temp = temp1.toString()
                        println(temp)
                        // This is checking if it's same word
                        // temp = hit
                        // cur == hit   then this would be true

                        // The found case
                        if (curr.compareTo(temp) == 0) {
                            println("found sth here")
                            // Why are we incrementing c here
                            // so it would then be a, b
                            ++c
                            println("$c")
                            continue  //Skip the same word
                        }

                        // Have reached the end word
                        if (temp.compareTo(endWord) == 0){
                            println(depth+1)
                            return depth + 1
                        } //endWord found}


                        /*
                        The not found case
                        This is not the same word found so far
                   if not same word found then try following,
                   Check if "bit" in the set that we began add it to q
                   and process
                   temp hit
                         */
                        if (myset.contains(temp)) {
                            q.add(temp)
                            myset.remove(temp)
                        }
                        ++c
                    }
                }
            }
            /*
             1st iter: c 'a' 97
             */

        }
        return 0
    }


fun main() {
    // this should return 5 as explained
    wordladder("hit", "cog",
    arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
}