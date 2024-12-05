

"""
aabcb
after 1st swap: abacb
after 2nd swap: abcab
after 3rd swap: abcba
"""


def minMovesToMakePalindrome(s)-> int:

    s = list(s)
    res = 0

    while s:

        """Find the first occrurence of the last index there 
        Once find it find the left most occur of that index 
        
        """
        # find the first index of the element that's there
        i = s.index(s[-1])

        # here the first occurence is the last oen (meaning there is only one)
        # out there so we move this to the center

        # "ababc"   be moving c there
        if i == len(s) -1:
            res+= (i//2)
        # but otherwise if we found one then move it to the front
        # move however many points to the front
        # adcadc    wanna move c to front so 2 swaps -> acdadc
        # cdaadc
        else:
            res+=1

            s.pop(i)

        #remove the last character there
        s.pop()

        return res

#    T: O (n/2 ) * O(n) => o(n^2)
#   s: O(n)