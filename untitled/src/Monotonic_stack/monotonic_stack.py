'''


Basically when a new item arrives we make sure existing bigger
element is removed in this case


Used to build a stack
Before pushing into the stack, POP all the elements till either of one condition fails:
Stack is not empty
Stack’s top is bigger than the element to be inserted.
Then push the element into the stack.
'''

def increasingStack(arr, n):
    stk = []
    for i in range(n):
        #either stack is empty or all bigger nums are popped off
        while (len(stk) > 0 and stk[-1] > arr[i]):
            stk.pop()
        stk.append(arr[i])

    print(stk)
# Driver code
arr = [1, 4, 5, 3, 12, 10]
N = len(arr)

# Function Call
increasingStack(arr,N)













