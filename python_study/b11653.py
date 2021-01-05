import sys


def isPrime(N):
    for i in range(2, N):
        if N % i == 0:
            return False
    return True


N = int(sys.stdin.readline())
for i in range(2, N+1):
    if isPrime(i) == False:
        continue
    while N % i == 0:
        print(i)
        N /= i
