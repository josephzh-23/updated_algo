package Hard

import tricks.print
import java.util.*


fun main() {
    var s = Sol()
    var s3 = "(joseph)asdf"
    s.calculate(s3).print()
}

/*
Basically as soon as we see a (, call the dfs function to calculate the number
  1 + ( 1 + 2 * 3) ) + 3
 */

public class Sol() {
    lateinit var arr: CharArray
    var index = 0
    fun calculate(s: String): String{
        arr = s.toCharArray()
        return dfs()
    }

    private fun dfs(): String {
        val stack = Stack<Char>()

        // Get rid of * and /
        while (index < arr.size) {
            if (arr[index] != ' ') {

                // If a digit here
                if (Character.isLetter(arr[index])) {
                    // build the number
                    val buildNum = StringBuilder()

                    while (index < arr.size && Character.isLetter(arr[index])) {
                        buildNum.append(arr[index])
                        index++
                    }

                    // to get back to the number 223+
                    // becomes 223
                    index--

                    // If (asdf)feg
                    // this will be asdf first, then feg in 2nd round
                    val str = buildNum.toString()
                    str.forEach{
                        stack.push(it)
                    }

                }

                // If a ( here
                else if (arr[index] == '(') {

                    // Increase index so no lnoger at (
                    // will be 1 idx after
                    index++
                    val curNum = dfs()
                    // Since it will be

                    // Once we hit a close bracket ), it will come here
                    // since returning the dfs above
                    // Why optor needed here?
                    println(curNum)
                    curNum.forEach {
                        stack.push(it)
                    }
                    // If closing here
                } else if (arr[index] == ')') {
                    break

                }
            }
            index++
        }
        var s = java.lang.StringBuilder()
        while(!stack.isEmpty()){
            s.append(stack.pop())
        }
        return s.toString()
    }

}