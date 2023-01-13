package Hard

import java.util.*

fun main() {
    var s = Stack<Int>()
    var curNum = "123+4"
    var opt = "+"
}

private fun insertElement(stack: Stack<Int>, curNum: Int, operator: Char) {
    var curNum = curNum
    if (operator == '-') {
        curNum *= -1
    } else if (operator == '*') {
        curNum *= stack.pop()
    } else if (operator == '/') {
        curNum = stack.pop() / curNum
    }
    println(stack)
    stack.push(curNum)
}