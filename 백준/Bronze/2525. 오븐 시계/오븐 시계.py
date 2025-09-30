h, m = map(int, input().split())
x = int(input())
h += x // 60
m += x % 60
if m >= 60:
    m %= 60
    h += 1
if h >= 24: 
    h %= 24
print(h, m)