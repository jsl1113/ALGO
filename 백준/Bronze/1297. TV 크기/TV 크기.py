import math
r, h, w = map(int, input().split())
x = math.sqrt(pow(h, 2) + pow(w, 2))
r = r / x
print(int(h * r), int(w * r))