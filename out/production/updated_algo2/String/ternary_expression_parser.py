


"""
can then go from the back here as said
T? 2: 3

We start evaluating from the back
"""
def parseTernary(expression: str)->str:
    s = []
    i = len(expression) -1

    while i >=0:
        if expression[i] == "?":
            trueVal = s.pop()
            falseVal = s.pop()

            i-=1

            if expression[i] == "T":
                s.append(trueVal)
            else:
                s.append(falseVal)
        elif expression[i] != ":":
            s.append(expression[i])
        i-=1
    return s[0]