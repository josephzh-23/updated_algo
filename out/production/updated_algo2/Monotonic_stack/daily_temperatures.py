
# decreasing O(n^2) down to O(n)


# When we find a warmer temperature, the number of days is
# the difference between the current index and the index on the top of the stack.
def increasingStack(temp):

    stk = []

    # ans[prevday] # of days that have passed betwen prevday and curday
    # ans[prevday] = curday - previday
    ans = [0] * len(temp)
    for curday, curtemp in enumerate(temp):
        # Pop until the current day's temperature is not
        # warmer than the temperature at the top of the stack
        # to make sure increasing stack
        while stk and temperatures[stk[-1]] < curtemp:

            # the prev day at which temp is warmer
            prevday = stk.pop()
            # so if it's (74, 1) popped compared to (75, 2)
            # then the ans[1] = 2- 1 = 1
            ans[prevday] = curday - prevday
        stk.append(curday)

    print(ans)

temperatures = [73, 74, 75, 71, 69, 72, 76, 73]

increasingStack(temperatures)









