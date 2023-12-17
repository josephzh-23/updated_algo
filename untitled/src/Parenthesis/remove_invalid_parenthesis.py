from typing import List


'''
Should try to build this to the best of our ability here 

Start from left -> right, and then make decision whether to take current or leave it
whether we have a left paren or to the right here

- In a backtracking manner here, the longer l == right, then the better it is here 

Case 1:
curlen = 5
if len > curlen, then reset the list since we found sth with smaller removes 
Check if left == right here, 
'''
class Solution():
    def __init__(self):
        self.res = None
        self.longestString = None

    def removeInvalidParenthesis(s, string: str)-> List[str]:
        s.longestString = -1
        s.res = set()

        # this would contain all the results here
        s.dfs(s, 0, [], 0, 0)
        return s.res


    def dfs(s, string, curidx, curres, lcount, rcount):

        # this is when we have a solution and start checking if valid or not
        if curidx>= len(string):

            # case when all parent removed, could just remove paren here?
            if lcount == rcount:

                # check if we have better answer then previous length
                if len(curres) > s.longestString:
                    s.longestString = len(curres)

                    # a new solution here and then add a current result here
                    s.res = set()
                    s.res.add("".join(curres))

                # just add our string here since this is just another valid answer
                elif len(curres) == s.longestString:
                    s.res.add("".join(curres))

        # the processing part, decide whether to take sth or not here or there
        else:
            curchar = string[curidx]
            if curchar == "(":

                # case 1: this is the case where we take it and so left increases by 1
                curres.append(curchar)
                s.dfs(string, curidx + 1, curres, lcount + 1, rcount)
                curres.pop()

                #case 2: the case where we don't include it, so lcount the same here
                s.dfs(string, curidx + 1, curres, lcount, rcount)

            elif curchar == ")":
                # case 1: we ignore the right paren
                s.dfs(string, curidx + 1, curres, lcount, rcount)

                '''
                Case 2: when we want to take the right paren
                
               Be careful here this is quite imporatn
               # this is the case where we take it
               # we can't take right greedily  
               
               Ex: (( )))   whatever we have on the right will not work
               since the first one is wrong (the first extra right needs to be closed here)
               '''
                # making sure it works here
                if lcount > rcount:
                    curres.append(curchar)
                    s.dfs(string, curidx + 1, curres, lcount, rcount + 1)
                    curres.pop()

            # in case we get a letter here, we always keep this here
            else:
                curres.append(curchar)
                s.dfs(string, curidx + 1, curres, lcount, rcount)
                curres.pop()

    # T: O(2^n)
    # SC: O(n)
                    