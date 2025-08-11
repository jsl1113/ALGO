arr = list(map(int, input().split()))
add = [pow(i,2) for i in arr]
print(sum(add) % 10)