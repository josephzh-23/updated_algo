package Numbers

object LargestNumber {
    fun swap(str: String, i: Int, j: Int): String {
        val ch = str.toCharArray()
        val temp = ch[i]
        ch[i] = ch[j]
        ch[j] = temp
        return String(ch)
    }

    // function to find the largest number
    // with given conditions.
    fun largestNum(num: Int): Int {
        // converting the number to the string
        var num_in_str = "" + num

        // By
        var temp = num_in_str

        // swapping each digit
        for (i in 0 until num_in_str.length) {
            for (j in i + 1 until num_in_str.length) {

                // Swapping and checking for the larger
                num_in_str = swap(num_in_str, i, j)
                if (temp < num_in_str) {
                    temp = num_in_str
                    println(temp)
                }

                // Reverting the changes when we are done here
                num_in_str = swap(num_in_str, i, j)
            }
        }
        return temp.toInt()
    }

    // Driver code
    @JvmStatic
    fun main(s: Array<String>) {
        var num = 4596
        println(largestNum(num))
    }
}