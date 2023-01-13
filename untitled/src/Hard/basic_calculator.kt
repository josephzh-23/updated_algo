package Hard

import java.util.*

fun main() {

}

fun calculate(s: String): Int {
    val stack = Stack<Int>()
    var operand = 0
    var result = 0 // For the on-going result
    var sign = 1 // 1 means positive, -1 means negative
    for (i in 0 until s.length) {
        val ch = s[i]
        if (Character.isDigit(ch)) {

            // Forming operand, since it could be more than one digit
            operand = 10 * operand + (ch.code - '0'.code)

            // + sign,
            // we first evaluate the expression to
        // the left and then save this sign for the next evaluation
        } else if (ch == '+') {

            // Evaluate the expression to the left,
            // with result, sign, operand
            result += sign * operand

            // Save the recently encountered '+' sign
            sign = 1

            // Reset operand
            operand = 0


        } else if (ch == '-') {
            result += sign * operand
            sign = -1
            operand = 0


        } else if (ch == '(') {

            // Push the result calculated sofar and sign on to the stack, for later
            // We push the result first, then sign
            // As if we are starting a new result
            stack.push(result)
            stack.push(sign)

            // Reset operand and result, as if new evaluation begins for the new sub-expression
            sign = 1
            result = 0
        } else if (ch == ')') {

            // Evaluate the expression to the left
            // with result, sign and operand
            result += sign * operand

            // ')' marks end of expression within a set of parenthesis
            // Its result is multiplied with sign on top of stack
            // as stack.pop() is the sign before the parenthesis
            result *= stack.pop()

            // Then add to the next operand on the top.
            // as stack.pop() is the result calculated before this parenthesis
            // (operand on stack) + (sign on stack * (result from parenthesis))
            result += stack.pop()

            // Reset the operand
            operand = 0
        }
    }
    return result + sign * operand
}
