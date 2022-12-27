package tricks

import top_tricks.swap


fun main() {
    var s = ""
    for(i in 1 until s.length){
        var word = s.toCharArray()
        if(word[i-1] == word[i]){
            swap(s, i, i+1)
        }
    }
}
