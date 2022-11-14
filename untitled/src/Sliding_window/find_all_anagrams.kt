import java.util.*

/*
OC : O (alphabet letter size * len(s))

construct sth like this
String :
a b c d e b a c b
shash :   idx:0  1 2  3 4    represent   -> 'a' 'b' 'c' 'd' 'e'
       count: 1  1 1  1 1

phash :   idx: 0 1 2  3 4
       count: 1  1 1  1 1

 */
fun findAnagrams(s:String, p:String): List<Int>{
    var ans = mutableListOf<Int>()
    var shash = IntArray(26)
    var phash = IntArray(26)

    var (left ,right) = Pair(0, 0)
    var window = p.length
    var len = s.length
    if(s.length==0 || s==null) return ans

    // store at each idx the frequencey of that letter
    var count = IntArray(26)

    if(len < window){

        return ans
    }


    // this is for the first window
    // set up all the counts
    while(right < window){
        phash[p[right]-'a']++
        shash[s[right++]-'a']++
    }

    right--

    // Now start sliding the window
    /*
    and each time when we slide we then
    1. dec count for leftMost char
    2. inc count for rightmost char
    2. If phash size == shash
     */
    while(right <len){

        // This is when all hash.size are the same
        // then add the left pointer
        if(Arrays.equals(phash, shash)){
            ans.add(left)
        }

        right++
        // So this is when not at the end yet
        if(right!= len){
            shash[s[right]-'a']++
        }

        shash[s[left]-'a'] --
        left++
    }
    ans.forEach{
        println(it)
    }
    return ans
}


fun main(){

    var s = "abab"
    var p = "ab"


    findAnagrams(s, p)

}