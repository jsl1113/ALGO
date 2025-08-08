day=['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
end=[31,28,31,30,31,30,31,31,30,31,30,31]

x, y=input().split()
x=int(x)
y=int(y)

tmp=0

for i in range(0,x-1):
    tmp+=end[i]

tmp+=y
print(day[tmp%7])