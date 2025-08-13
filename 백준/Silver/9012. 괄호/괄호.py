n = int(input())
for i in range(n):
    sentence = list(input())
    cnt = 0
    for s in sentence:
        if s == '(':
            cnt += 1
        elif s == ')':
            cnt -= 1
        if cnt < 0:
            print('NO')
            break
    if cnt > 0:
        print('NO')
    elif cnt == 0:
        print('YES')