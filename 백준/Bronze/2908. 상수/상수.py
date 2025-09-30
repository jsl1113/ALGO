# B2908
n, m = map(str, input().split())
n, m = int(n[::-1]), int(m[::-1]) # 문자열 reverse
print(max(m, n))