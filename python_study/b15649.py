import sys
import math
N, M = list(map(int, sys.stdin.readline().split()))
for i in range(1, math.factorial(N)//math.factorial(N-M)+1):
    for j in range(1, M+1):
        print(j, end=' ')
    print()
