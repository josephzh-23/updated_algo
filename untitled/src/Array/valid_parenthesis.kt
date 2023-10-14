package Array

import java.util.*


// Valid parenthesis here


fun main() {

    val mappings: HashMap<Char, Char>

    // Initialize hash map with mappings. This simply makes the code easier to read.
    mappings = HashMap()
    mappings[')'] = '('
    mappings['}'] = '{'
    mappings[']'] = '['
    var arr = "()[]{}"

    var s = Stack<Char>()

    //
    for(elem in arr.toCharArray()){

        // Process for later
        if(elem == '(' || elem == '[' || elem == '{'){
            s.add(elem)
        }

        if(mappings.containsKey(elem)){
            if(s.peek() == mappings[elem] ){
                s.pop()
            }
        }
    }

    if(s.isEmpty()) // we are good
        else {}// not good
}