a,b,c = map(int, input().split())
x = int(input())
a += (x // 60) // 60
b += (x // 60) % 60
c += x % 60

if c >= 60:
    c %= 60
    b += 1
if b >= 60:
    b %= 60
    a += 1
if a >= 24:
    a %= 24
    
print(a,b,c)