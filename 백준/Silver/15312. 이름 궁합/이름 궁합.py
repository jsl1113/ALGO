def f(arr):
    result = []
    for i in range(len(arr)-1):
        n1 = arr[i]
        n2 = arr[i+1]
        result.append((n1+n2) % 10)
    return result

a = [3,2,1,2,3,3,2,3,3,2,2,1,2,2,1,2,2,2,1,2,1,1,1,2,2,1]
# 1 3 2 3 2 2
x = input()
y = input()
d1,d2 = [],[]

for i in range(len(x)):
    d1.append(x[i])
    d1.append(y[i])

for i in range(len(d1)):
    d2.append(a[ord(d1[i])-65])
    
while(len(d2) != 2):
    d2 = f(d2)

print(str(d2[0]) + str(d2[1]))