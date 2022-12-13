package Sliding_window
/*

Time complexity : O(n^2)O(n
expand around the center for odd and even case

 */
fun longestPalindromeString(
        s:String
):String{

    var res = ""
    // Storign the result of the length
    var reslen = 0

    for(i in s.indices){

        // Take care of odd length case
        var (l, r) = Pair(i, i)
        while(l >=0 && r < s.length && s[l] == s[r]){

            // where we need to update the win len
            if((r-l + 1) > reslen){
                res = s.substring(l, r+1)
                reslen = r- l + 1
            }

            // Always
            l--
            r++

        }
        l = i
        r= i+1

        while(l>=0 && r< s.length && s[l] == s[r]){

            if((r-l + 1) > reslen){
                res = s.substring(l, r+1)
                reslen = r- l + 1
            }
        }

    }
    return res
}