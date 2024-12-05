
def calculate(str, l, r):
    if(l == r):
        print(''.join(str))

    for i in range(l, r):
        str[i], str[l] = str[l], str[i]
        calculate(str, l + 1, r)

str = "abc"
calculate(list(str), 0, len(str))
