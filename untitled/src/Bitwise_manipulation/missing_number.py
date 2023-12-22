

"""
Missing number here
[3, 0, 1]
missing is 2 here as said 2 is the msising number in the code

"""

# how can this be done using bit manipulation
"""
missing
=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
=0∧0∧0∧0∧2
=2
 

"""
def missingNumber(nums):
    missing = len(nums)
    for i, num in enumerate(nums):
        missing = (i ^num)









