while True:
    t = list(map(int, input().split()))
    n = max(t)
    if t[0] == 0 and t[1] == 0 and t[2] == 0:
        break
    t.remove(n)
    if pow(t[0],2) + pow(t[1],2) == pow(n,2):
        print("right")
    else:
        print("wrong")