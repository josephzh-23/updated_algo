package String_manipulation

// Method that adds spaces into a string at specified indices.
fun addSpaces(s: String, spaces: IntArray): String {
    // StringBuilder is used for efficient string manipulation
    val result = StringBuilder()


    // Use two pointers: 'i' for string 's', and 'j' for the spaces array
    var i = 0
    var j = 0

    // We can initiralize the 2 above outside then this is intersting here
    while (i < s.length) {
        // Check if we have more spaces to add and if the current position matches the next space position
        if (j < spaces.size && i == spaces[j]) {
            // If so, append a space to the result
            result.append(' ')
            // Move to the next position in the spaces array
            ++j
        }
        // Append the current character from string 's'
        result.append(s[i])
        ++i
    }


    // Return the modified string with spaces added
    return result.toString()
}
