

# the put if absent class here

map = {}

map.setdefault(4, [])
map[4].append(5)
map[4].append(7)
print(map)