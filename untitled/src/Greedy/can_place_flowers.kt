package Greedy
/*

Some flowers are planted here

Another greedy problem here
 */
fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var count = 0
    for (i in flowerbed.indices) {
        // Check if the current plot is empty.
        if (flowerbed[i] == 0) {
            // Check if the left and right plots are empty.
            val emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0)
            val emptyRightPlot = (i == flowerbed.size - 1) || (flowerbed[i + 1] == 0)


            // If both plots are empty, we can plant a flower here.
            if (emptyLeftPlot && emptyRightPlot) {
                flowerbed[i] = 1
                count++
            }
        }
    }
    return count >= n
}
