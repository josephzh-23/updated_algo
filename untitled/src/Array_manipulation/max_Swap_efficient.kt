package Array_manipulation

/*

usisng a more efficient manner and method here

Involves moving the largest digit forward to replace a smaller one here

To achieve this, we make two passes over the number. In the first pass,
    we scan from right to left to identify and store the largest digit we find and its position.

To achieve this second one here:
    2)We make 2 passes here,

    In the first pass, scan from left to rigth store the largest position and its position

    And using the numbers above we would then have the code

      2736



      In the 1st pass here then we have


        In the second pass, we move from left to right. Now that we know, for each position,
    the largest digit that appears after it, we check if we can make a swap.

        The first time we find a digit that is smaller than the largest one that comes after it,
    we swap them. Since we’re always looking for the largest possible swap, this guarantees that we’ll maximize the number.


 */

fun maxSwap(num:Int){

    var digits = num.toString().toCharArray()
    var length =
}