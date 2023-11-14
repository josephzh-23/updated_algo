package Graph.Advanced

import January_3rd.print
import java.util.*


/*
s = "011010", minJump = 2, maxJump = 3
the min and the max here and then some more here

 */
fun main() {
    val s = "011010"
    val minJump = 2
    val maxJump = 3
    canReach(s, minJump, maxJump).print()
}
fun canReach(s: String, minJump: Int, maxJump: Int):Boolean{

    val q = LinkedList<Int>()
    q.offer(0)
    for(i in 1 until s.length){
        if(s[i] =='0'){
            // This is to check if the front eleemtn has reached its capacity here
            while(!q.isEmpty() && q.peek() < i - maxJump){
                q.poll()
            }
            if(q.isEmpty()) return false
            val prev = q.peek()
            // So this satisifes the condition in the problem
            if(prev + maxJump >= i && prev + minJump <=i){
                q.offer(i)
                println("previous is $prev and current $i")
                // We have reached the end
                if(i == s.length - 1) return true
            }
        }
    }
    return false
}