# Python program for the above approach

# Function to find the difference between
# averages of the maximum and the minimum
# subarrays of length k
def Avgdifference(arr, N, K):

    # Stores min and max sum
    min = 1000000;
    max = -1;

    # A double for look
    for i in range(N - K + 1):
        sum = 0;

        # Sum up next K elements
        for j in range(K):
            sum += arr[i + j];

        # Update max and min moving sum
        if (min > sum):
            min = sum;
        if (max < sum):
            max = sum;


    # Return the difference between max
    # and min average
    return (max - min) / K;


# Driver Code

# Given Input
arr = [3, 8, 9, 15];
N = len(arr);
K = 2;

# Function Call
print(Avgdifference(arr, N, K));

# This code is contributed by _saurabh_jaiswal.