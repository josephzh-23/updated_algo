package String


// Use sliding window with this
fun permutationInString(s1: String, s2:String):Boolean{

    var l1 = s1.length
    var l2 = s2.length
    var dict1: MutableMap<Char, Int> = HashMap()
    var dict2: MutableMap<Char, Int> = HashMap()

    for(c in s1.toCharArray()){
        dict1.put(c, dict1.getOrDefault(c,0)+1)
    }


    for(i in s2.toCharArray().indices){
        if(i >= l1){
            var count = dict2[s2[i-l1]]
            count = count!! - 1
            dict2[s2[i-l1]] = count
        }
//        var count2 = dict2[s2[i]]
//        count2 = count2!! + 1
//        dict2[s2[i]] = count2
        dict2.put()
        if(dict1.size== dict2.size) return true

    }

    // And then usign these 2 we have
    return false
}