
def isVowel(ch):
    return ch in ['a', 'e', 'i', 'o', 'u']

# Returns count of vowels in str
def countVowels(str):
    count = 0
    for i in range(len(str)):

        # Check for vowel
        if isVowel(str[i]):
            count += 1
    return count

# Driver Code

# string object
str = 'abc de'

# Total number of Vowels
print(countVowels(str))

# This code is contributed
# by SamyuktaSHegde