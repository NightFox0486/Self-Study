import sys
li = set()
N = int(sys.stdin.readline())
for i in range(N):
    li.add(sys.stdin.readline())
li = list(li)
li.sort()
li = sorted(li, key=len)
for i in li:
    print(i, end='')
