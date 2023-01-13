package Stacks_Queue


import tricks.print
import java.util.*


/*
1. We push the elements of the
 expression one by one onto the stack until we get a closing bracket )

 2.  Then we pop the elements from the stack one by one and evaluate the expression on-the-go.
  This is done till we find the corresponding ( opening bracket.
 */

fun main() {

    var s = "(()))"
    solution(s).print()
}

fun solution(str: String) {
    val mappings: HashMap<Char, Char>

    var s = Stack<Char>()
// Initialize hash map with mappings. This simply makes the code easier to read.
    mappings = HashMap()
    mappings[')'] = '('

    // an opening bracket
    for(c in str.toCharArray()){
        // an opening bracket here
        if(mappings.containsValue(c)){

            if(s.isEmpty()){
                s.push(c)
            }else if(s.peek()!='('){
                s.add(c)
            }

            // an closing bracket
        }else{
            if(s.peek() == 'c'){
                s.add(c)
            }
        }
    }
    println(s)

}
