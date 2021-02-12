import sys


def findans(idx):
    if idx == M:
        for i in range(M):
            print(arr[i], end=' ')
        print()
        return
    for i in range(1, N+1):
        arr[idx] = i
        findans(idx+1)


N, M = list(map(int, sys.stdin.readline().split()))
arr = [0] * M
findans(0)
