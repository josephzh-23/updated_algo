package Hard

import java.util.*


internal class Solution32 {
    fun calculate(s: String?): Int {
        if (s == null || s.isEmpty()) return 0
        val len = s.length
        val stack = Stack<Int>()
        var currentNumber = 0
        var operation = '+'
        for (i in 0 until len) {
            val currentChar = s[i]
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar.code - '0'.code)
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                // + - cases push to stack to be popped later
                if (operation == '-') {
                    stack.push(-currentNumber)
                } else if (operation == '+') {
                    stack.push(currentNumber)

                    // * and / cases here
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber)
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber)
                }
                operation = currentChar
                currentNumber = 0
            }
        }
        var result = 0
        while (!stack.isEmpty()) {
            result += stack.pop()
        }
        return result
    }
}