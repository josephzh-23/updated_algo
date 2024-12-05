package String_manipulation

/*

To make the string beautiful

Contain only 0s and 1s here




The core of the solution involves iterating through the string, but instead of looking at every character,
we only examine characters at every odd index, which are $1, 3, 5, \cdots$.

This approach works because beautiful substrings need to be in pairs (00 or 11), and any discrepancy
 in these pairs would be caught when comparing the odd-indexed character with its directly preceding even-indexed character.

        During each iteration of the loop, we compare the character at the current index i to the one before it s[i - 1].
 If the characters are different, s[i] != s[i - 1], it signals that we would need to
 change the character at index i to make the pair of characters the same,
 thus contributing towards a beautiful substring.



    Bascailly the code works like the following here

    Let's consider a small binary string as an example to illustrate the solution approach: s = "010101". We aim to find the minimum number of changes needed to make s beautiful.

With the solution approach in mind, we inspect the characters at the odd indices of s and compare each with the preceding even index character to identify where changes are needed.

i = 1: We compare s[1] with s[0]. Here, s[1] = '1' and s[0] = '0'.
Since s[1] != s[0], this indicates that we need to make one change to make the substring s[0:2] beautiful.

i = 3: We compare s[3] with s[2]. Here, s[3] = '1' and s[2] = '0'.
 Once again, we see that s[3] != s[2], signaling the need for another change for the substring s[2:4] to be beautiful.

i = 5: Finally, we compare s[5] with s[4]. We find that s[5] = '1' and s[4] = '0',

    which means s[5] != s[4]. This means a change is required for the substring s[4:6] to conform to the beautiful criteria.


 */




internal class Solution15 {
    // Method to find the minimum number of changes required to make all characters at even indices
    // the same as the previous characters at odd indices in a given string.
    fun minChanges(s: String): Int {
        var changesNeeded = 0 // Initialize a counter for the number of changes needed


        // Iterate over the string starting from the second character, checking every other character
        var i = 1
        while (i < s.length) {
            // If the current character is not the same as the previous character,
            // we need to change it to make it the same
            if (s[i] != s[i - 1]) {
                changesNeeded++ // Increment the counter for the number of changes needed
            }
            i += 2
        }


        // Return the total number of changes required to make the string's odd and even characters match
        return changesNeeded
    }
}











