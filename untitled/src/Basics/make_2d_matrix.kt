package Basics

fun main() {


    // And then here we have the code

    var arr = Array(4) { IntArray(3) }
    for(i in 0 until arr.size){
        for (j in 0 until arr[0].size){
            arr[i][j] = 0
        }
    }
    print(arr)
}