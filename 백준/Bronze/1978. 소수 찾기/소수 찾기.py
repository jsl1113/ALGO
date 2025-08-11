n = int(input())
arr = list(map(int, input().split()))

def prime(num):
    if num == 1:
        return False
    elif num == 2:
        return True
    for i in range(2, num):
        if num % i == 0:
            return False
    return True

cnt = 0            
for a in arr:
    if prime(a):
        cnt += 1
print(cnt)