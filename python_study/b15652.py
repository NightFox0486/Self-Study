import sys


def findans(idx):
    if idx == M:
        for i in range(M):
            print(arr[i], end=' ')
        print()
        return
    for i in range(1, N+1):
        if check[i]:
            continue
        for j in range(1, i):
            check[j] = True
        arr[idx] = i
        findans(idx+1)
        for j in range(1, i):
            check[j] = False


N, M = list(map(int, sys.stdin.readline().split()))
check = [False] * (N+1)
arr = [0] * M
findans(0)
