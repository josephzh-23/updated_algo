"""
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.

Use binary search tree to find solution to this here
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# after identifying the closest value
class binarySearchTreeValues:

    # no need to traverse the whole tree
    # if nums[i] <= target < nums[i + 1]
    def closestValue(s, r: TreeNode, target):

        # nearest is like a tracker here to see what's closest
        nearest = float("inf")

        while r:
            if r.val == target: return r.val

            # we keep updating the value of this here
            if abs(r.val - target) < abs(nearest - target): nearest = r.val
            if abs(r.val - target) == abs(nearest - target): min(r.val, nearest)


            if r.val > target:
                r = r.left
                # r.val < target
            else:
                r  = r.right










