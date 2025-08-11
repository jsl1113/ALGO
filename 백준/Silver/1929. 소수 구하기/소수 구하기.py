import sys

def prime(num):
    if num == 1:
        return False
    elif num == 2:
        return True
    for i in range(2, int(num**0.5)+1):
        if num % i == 0:
            return False
    return True

m, n = map(int, sys.stdin.readline().split())

s = ''
for i in range(m, n+1):
    if prime(i):
        s += (str(i) + '\n')
print(s)