import January_3rd.print

/*

https://leetcode.com/problems/minimum-window-substring/description/
O(n + m)    this will be the end
S will be sth like the following
"ADOBECODEBANC"
t will be "ABC"

Now let's go over this problem again

1. Given s and t

Every substring s such that every character in t appears in it here

2. And this is quite interesitng


T = "ABC"
S

Step 1:
A D O B E C O D E B A N C
i
j

count = 3
left = 0        right = 12 (there are 12 indices)
found = false
What's count?

    It's the map size, when all characters are found size becomes 0
at beginning the size is just 3

    We have a map at the start of this since no character has been found yet
{A : 1, B: 1, C: 1}




At idx = 0, A is found then map becomes
{A : 0, B: 1, C: 1}
count = 2

Step 2:
Then move j forward
A D O B E C O D E B A N C
i
      j
-We keep moving j forward until B is found here
then reduce char count in map
{A : 0, B: 0, C: 1}
count = 1

Step 3
Then keep moving j until 'c' is found
A D O B E C O D E B A N C
i
          j
{A : 0, B: 0, C: 0}     everything becomes 0 here
count = 0

Step 4
mve i up by 1
A D O B E C O D E B A N C
i
          j

  And now, count = 1       minLenght = 5
  left = 0  right = 5           found = true


step 5:
Then we start moving i and j both
A D O B E C O D E B A N C
  i
            j
  And now, count = 1       minLenght = 5
  left = 0  right = 5           found = true

 At this point since A is not in the map anymore, we have
 we increment A by 1 here
 {A : 1, B: 0, C: 0}     everything becomes 0 here
 */
fun minWindow(s: String, t: String): String {
    if (s == null || t == null || s.isEmpty() || t.isEmpty()) return ""
    val map = mutableMapOf<Char, Int>()

    // You need 3 indices here
    for (i in t.indices) {

        val c = t[i]
        map.apply {
            put(c, getOrDefault(c, 0) + 1)
        }
    }

    /*
    The count is is for keeoing track of how many letters are found based on the input
    t
     */
    var (i, j, count) = intArrayOf(0, 0, map.size)


    // This is for adjusting the min
    var (left, right, min) = intArrayOf(0, s.length - 1, s.length)

    // Check if the one can actually be found here
    var found = false

    while (j < s.length) {

        val endChar = s[j++]


        if (map.containsKey(endChar)) { // Decrement this value in 1
            map.put(endChar, map.getOrDefault(endChar, 0) - 1)
            if (map[endChar] == 0) count -= 1
        }

        if (count > 0) continue

        // We increase the start character, count is the size of the map
        //
        while (count == 0) {
            val startChar = s[i++]

            // Found sth that's in the t word
            if (map.containsKey(startChar)) {
                map.apply {
                    put(startChar, getOrDefault(startChar, 0) + 1)
                    if (getOrDefault(startChar, 0) > 0) {

                        /*
                        Increase the count again at the since there is
                        now more then 1 character going back to the map


                         */
                        count += 1
                    }
                }
            }

            // this is where we have to make the update to the min length
            if ((j - i) < min) {
                left = i
                right = j
                min = j - i
                found = true

            }
        }
    }

    // This is the final answer here

    return if (!found) "" else s.substring(left - 1, right)
}

fun main() {
    var s = "adobecodebance"
    var t = "abc"
    minWindow(s, t).print()
}
