import sys
N = int(sys.stdin.readline())
arr = [[0 for _ in range(2)] for _ in range(N)]
for i in range(N):
    arr[i] = list(sys.stdin.readline().split())
    arr[i][0] = int(arr[i][0])
arr = sorted(arr, key=lambda x: x[0])
for i in range(len(arr)):
    print(arr[i][0], arr[i][1])
