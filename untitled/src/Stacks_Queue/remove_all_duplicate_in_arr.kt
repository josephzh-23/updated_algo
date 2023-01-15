package Stacks_Queue

import java.util.*

// Using a stack here you can solve this easily


fun main() {
    var str = "abbacd"
    removeAdjacentDup(str)
}
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
fun removeAdjacentDup(str: String){
    var s = Stack<Char>()
    var sb = StringBuilder()

    for(c in str.toCharArray()){
        if(s.isEmpty()){
            s.push(c)
        }else if(s.peek() == c){
            s.pop()
        }else{
            s.push(c)
        }
    }
    while(!s.isEmpty()){
        sb.append(s.pop())

    }
    println(sb.reverse())
}