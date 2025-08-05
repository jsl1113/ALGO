n = int(input())
L = [1]
L += list(map(int, input().split()))
L.sort()

if (len(L)+1)%2 == 0:
    idx = (len(L)+1)//2
    print(L[idx - 1] * L[idx])
else:
    idx = (len(L)+1)//2 + 1
    print(L[idx - 1] * L[idx - 1])