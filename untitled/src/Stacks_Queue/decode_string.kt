package Stacks_Queue

import java.util.*

fun main() {

}

// THis question has to do with
fun decodeString(s: String): String {
    var st = Stack<Char>()
    for(i in 0 until s.length){
        if(s[i]!=']'){
            st.add(s[i])
        }
        else{
            var substr = ""

            // This is for when popping very important
            while(st.peek()!='['){
                substr = st.pop() + substr
            }
            st.pop()

            var k = ""
            // if it's digit we keep this up
            while(!st.isEmpty()&&st.peek().isDigit()){
                k = st.pop() + k

            }
            st.add((k.toInt() *substr.toInt()).toChar())
        }
    }
    // sort the decode string question here
}