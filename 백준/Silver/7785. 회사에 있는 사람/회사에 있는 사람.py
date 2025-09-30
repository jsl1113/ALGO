n = int(input())
result = dict() 
for _ in range(n):
    name, action = input().split()
    if action == "enter":
        result[name] = True 
    else: 
        del result[name] 
            
print("\n".join(sorted(result.keys(), reverse=True)))