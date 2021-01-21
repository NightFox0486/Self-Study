import sys
import math


def findanswer(idx):
    if idx == M:
        for i in range(M):
            print(ans[i], end=' ')
        print()
        return
    for i in range(1, N+1):
        if check[i-1]:
            continue
        check[i-1] = True
        ans[idx] = i
        findanswer(idx+1)
        check[i-1] = False


N, M = list(map(int, sys.stdin.readline().split()))
check = [False]*(N)
ans = [0]*(M)
findanswer(0)
