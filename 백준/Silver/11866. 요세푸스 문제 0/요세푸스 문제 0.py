n, k = map(int, input().split())
p = list(range(1, n+1))

ans = []
i = k-1
while len(ans) < n-1:
    ans.append(p.pop(i))
    i = (i + k-1) % len(p)
ans.append(p[0])    
print('<'+', '.join(map(str, ans)) + '>')    