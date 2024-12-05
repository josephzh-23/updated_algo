"""
Put words into buckets for
words = ['dog', 'cat', 'cop']

Put words into bucket so that
'c': ('cat', 'cop')

"""
from collections import defaultdict


def numMatchingSubseq(str, words):
    alpha = defaultdict(list)
    for w in words:
        letter = w[0]
        # each letter will have a word
        # a : aa
        # b: bb     a: acd
        alpha[letter].append(w)

    count = 0
    for char in str:
        # bb because char is b
        oldbucket = alpha[char]
        alpha[char] = []

        for w in oldbucket:

            #if next word cd, we put in map 'c': {d}
            nextword = w[1:]
            print("next word is", nextword)
            if nextword:
                alpha[nextword[0]].append(nextword)
            # if no more next word, we have reached end, then that means
            # 1 match is found, s = "abcde"        words = "a"
            else:
                count += 1
    return count

s = "abcde"; words = ["a", "bb", "acd", "ace"]
numMatchingSubseq(s, words)










