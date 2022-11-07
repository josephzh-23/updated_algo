
// Using array and list
fun main() {
    /*
With array you can't change value but can do following
initialize first and then assign value a very good way of doing things

 */
   // Notice this one doesn't have any value will crash
   var array = intArrayOf(4)
   array[0] =3
   // THis will give exception as said
//   println(array[1])

   // An array initialized should have the following
   var array2= IntArray(3)
   array2.forEach { println(it) }

}