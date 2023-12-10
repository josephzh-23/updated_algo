"""

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
"""

# the above does kind of make sense here

def evaluateResult(tokens)-> int:
    s = []
    # we had 2 previous then
    for c in tokens:
        if c == "+":
            s.append(s.pop() + s.pop())
        elif c == "-":
            a, b = s.pop(), s.pop()
            s.append(b-a)
        elif c == "*":
            s.append(s.pop() * s.pop())
        elif c == "/":
            s.append(int(s.pop() / s.pop()))
        else:
            s.append(c)
    return s[0]