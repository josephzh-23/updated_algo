

class Node:
    """
    Here v is the vertex and d is the distance here
    """

    def __init__(s, v, distance):
        s.v = v
        s.distance = distance

    # define a comparator in python
    def __lt__(s, other):
        return s.distance < other.distance

    # fxn to implement Dikjstra's algo to find shortest path, v being the size here
pokemon_objects = [Node(4, 5),Node(3, 2), Node(1, 4)]

sorted(pokemon_objects, key=lambda x: x.distance)  # sort by attack
print(pokemon_objects)
