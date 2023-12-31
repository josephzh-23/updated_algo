import collections
from bisect import bisect
from typing import List

"""
fs.mkdir here has the code

create directory a in directory / then create b in a, then create c in b

fs.mkdir("/a/b/c")

"""


class FileSystem:

    def __init__(s):
        s.paths = collections.defaultdict(list)
        s.files = collections.defaultdict(str)

        """
        ls : if nothign in ls then return empty

        If path is a file path: return a list containing a file's name
                /a/b/c.js     -> c.js
        if path is dir path:
            return list of files and dir names in this directory

        The answer in lexicographic order
        """

    def ls(s, path: str) -> List[str]:
        # for returning the file name here
        if path in s.files:
            return [path.split("/")[-1]]  # return the last one there
        else:
            return s.paths[path]

    def mkdir(s, path: str) -> None:
        directories = path.split("/")  # given a, b, c here

        # take care of the leading slash there
        for i in range(1, len(directories)):
            # create a new directory from the point we are at
            # why or "/"? if nothing exists we just have a new /
            cur = "/".join(directories[:i]) or "/"

            if cur not in s.paths or directories[i] not in s.paths[cur]:
                # insert this into the path in lexicological order
                bisect.insort(s.paths[cur], directories[i])

    def addContentToFile(s, filePath: str, content: str) -> None:
        if filePath not in s.files:
            s.mkdir(filePath)

        s.files[filePath] += content

    def readContentFromFile(s, filePath: str) -> str:
        return s.files[filePath]
