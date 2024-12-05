package String_manipulation

/*

And this is only part 1 of this solution here and then we will have the code

1 0 0 1


An interesting poiknt here to be taken here seriously here



 */

/*

In this eaxmple given here what we do is we change s[1] to 1 and s[3] to 0 get string
"1100" as the nubmer 1 step here and that's important in general here
 */
fun main() {
    var s = "1001"
    minChanges(s)
}

fun minChanges(s: String): Int {
    // Initialize with first character of string
    var currentChar = s[0]

    var consecutiveCount = 0
    var minChangesRequired = 0

    // Iterate through each character in the string
    for (i in 0 until s.length) {
        // If current character matches the previous sequence
        if (s[i] == currentChar) {
            consecutiveCount++
            continue
        }
        /*

        For example here if we have 1001

        consecutive count will be 1 in both cases and then we would have
         */
        println("the consecutive count is " + consecutiveCount)
        // If we have even count of characters, start new sequence
        if (consecutiveCount % 2 == 0) {
            consecutiveCount = 1
        } else {
            consecutiveCount = 0
            minChangesRequired++
        }

        // Update current character for next iteration
        currentChar = s[i]
    }

    return minChangesRequired
}
