import sys
N = int(sys.stdin.readline())
arr = [[0 for _ in range(2)] for _ in range(N)]
for i in range(N):
    arr[i] = list(map(int, sys.stdin.readline().split()))
arr.sort()
for i in range(len(arr)):
    print(arr[i][0], arr[i][1])
