import sys
import math
N, M = list(map(int, sys.stdin.readline().split()))
for i in range(math.factorial(N)-math.factorial(N-M)):
    for j in range(M):
        print()
    print()
