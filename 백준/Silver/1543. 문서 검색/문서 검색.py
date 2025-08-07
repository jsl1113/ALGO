doc = input()
search = input()

count = 0
i = 0

while i <= len(doc) - len(search):
    if doc[i:i+len(search)] == search:
        count += 1
        i += len(search)
    else:
        i += 1
        
print(count)