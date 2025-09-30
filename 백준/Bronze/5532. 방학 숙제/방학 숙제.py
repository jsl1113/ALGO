import math
L=int(input())
a=int(input())
b=int(input())
c=int(input())
d=int(input())
ans1=math.ceil(a/c)
ans2=math.ceil(b/d)
ans=L-ans1 if ans1>=ans2 else L-ans2
print(ans)