import java.util.*


fun main() {
    // Encode the string here and you get
    var str = "3[a2[c]]"
}

fun decodeString(s: String): String {
    val countStack = Stack<Int>()
    val stringStack = Stack<StringBuilder>()
    var currentString = StringBuilder()
    var k = 0
    for (ch in s.toCharArray()) {
        if (Character.isDigit(ch)) {
            k = k * 10 + ch.code - '0'.code
        } else if (ch == '[') {
            // push the number k to countStack
            countStack.push(k)
            // push the currentString to stringStack
            stringStack.push(currentString)
            // reset currentString and k
            currentString = StringBuilder()
            k = 0
        } else if (ch == ']') {
            val decodedString = stringStack.pop()

            // this is important too
            println(decodedString)
            // decode currentK[currentString] by appending currentString k times
            for (currentK in countStack.pop() downTo 1) {
                decodedString.append(currentString)
            }
            currentString = decodedString
        } else {
            currentString.append(ch)
        }
    }
    return currentString.toString()
}