from math import gcd
def lcm(x, y):
    return x * y // gcd(x, y)

n, m = map(int, input().split())
print(gcd(n, m))
print(lcm(n, m))