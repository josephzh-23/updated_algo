package Stack

import java.util.*


fun removeDuplicateLetters(s: String): String {
    val stack: Stack<Char> = Stack()

    // this lets us keep track of what's in our solution in O(1) time
    val seen = HashSet<Char>()

    // this will let us know if there are any more instances of s[i] left in s
    val last_occurrence = HashMap<Char, Int>()
    for (i in 0 until s.length) last_occurrence[s[i]] = i

    for (i in 0 until s.length) {
        val c = s[i]
        // and then we can add this to our code base for now and seek other methods to work on this data for the current iteration
        // We have to make sure our solution is also unique here and that's also important
        // we can only try to add c if it's not already in our solution
        // this is to maintain only one of each character
        if (!seen.contains(c)) {
            // if the last letter in our solution:
            //     1. exists
            //     2. is greater than c so removing it will make the string smaller
            //     3. it's not the last occurrence
            // we remove it from the solution to keep the solution optimal
            while (!stack.isEmpty() && c < stack.peek() && last_occurrence[stack.peek()]!! > i) {
                seen.remove(stack.pop())
            }
            seen.add(c)
            stack.push(c)
        }
    }
    val sb: StringBuilder = StringBuilder(stack.size())
    for (c in stack) sb.append(c)
    return sb.toString()
}

fun main() {
    removeAllDuplicateLetters("bcabc")
}














