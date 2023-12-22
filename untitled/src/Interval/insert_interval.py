from Two_array.find_difference_of_two_array import size


# and to do this here would be a lot of work
def insert(s, intervals, newInterval):

    res = []
    for i in size(intervals):

        # if the end of the new interval < the start of cur
        if newInterval[1] < intervals[i][0]:
            res.append(newInterval)
            # everything from that point on
            return res + intervals[i:]

        # if the 1st one is bigger here then
        elif newInterval[0] > intervals[i][1]:
            res.append(intervals[i])

            # if there is overlap between new and current then the basic
            # will be
        else:
            newInterval = [min(newInterval[0], intervals[i][0]),
                           max(newInterval[1], intervals[i][1])]




    # not gonna add things just yet
    res.append(newInterval)     # that's the new functino up there
    return res 





