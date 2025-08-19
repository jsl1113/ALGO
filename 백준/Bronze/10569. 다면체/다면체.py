t=int(input())
answer=[]
for _ in range(t):
    v,e=input().split()
    v=int(v)
    e=int(e)
    result=2+e-v
    answer.append(result)
for i in range(t):
    print(answer[i])