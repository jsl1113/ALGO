num=[]

for i in range(0,9):
    tmp=int(input())
    num.append(tmp)
    
add=sum(num)
b=True
for i in range(0,8):
    for j in range(i+1,9):
        tmp=add-num[i]-num[j]
        if tmp==100:
            x=i
            y=j
            b=False
    if b==False:
        break
            
if x>y:
    del num[y]
    del num[x-1]
else:
    del num[x]
    del num[y-1]
    
num.sort()
for i in range(0,7):
    print(num[i])