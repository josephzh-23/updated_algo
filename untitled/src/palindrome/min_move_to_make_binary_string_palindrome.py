
"""
Input: N = 12
Output: 2
Explanation:
Binary String representing 12 = “1100”.
To make “1100” a palindrome, convert the string to “0110”.
Therefore, minimum bits required to be flipped is 2.
Input: N = 7
Output: 0
Explanation:
Binary String representing 7 = 111, which is already a palindrome.

"""



# Function to check if the bit present
# at i-th position is a set bit or not
def check_ith_bit(n, i):

    # If different then becomes 0, otherwise 1
    if (n & (1 << (i - 1))):
        return True
    else:
        return False



# Function to count the minimum
# number of bit flips required
def no_of_flips(n):

    # Length of the binary form
    ln = checklength(n)

    # Number of flips
    ans = 0

    # Pointer to the LSB
    right = 1

    # Pointer to the MSB
    left = ln

    while (right < left):

        # Check if the bits are equal
        if (check_ith_bit(n, right) !=
                check_ith_bit(n, left)):
            ans += 1

        # Decrementing the
        # left pointer
        left -= 1

        # Incrementing the
        # right pointer
        right += 1

    # Returns the number of
    # bits to flip.
    return ans

# Driver Code
n = 12








# check the length of bit here
def checklength(n):
    ans = 0 # here is the length
    while(n):
        n = n >>1
        ans+=1      #incremenet the length
    return ans



