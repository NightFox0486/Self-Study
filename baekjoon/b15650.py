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
        arr[idx] = i
        check[i] = True
        findans(idx+1)
        for j in range(i+1, N+1):
            check[j] = False


N, M = list(map(int, sys.stdin.readline().split()))
check = [False]*(N+1)
arr = [0]*(M+1)
findans(0)
