import sys
from collections import Counter
N = int(sys.stdin.readline())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline()))
arr.sort()
most = Counter(arr).most_common()
print(round(sum(arr)/N))
print(arr[N//2])
if len(most) > 1:
    if most[0][1] == most[1][1]:
        print(most[1][0])
    else:
        print(most[0][0])
else:
    print(most[0][0])
print(arr[N-1]-arr[0])
