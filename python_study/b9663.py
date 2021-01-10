import sys


def findans(idx, n_q, count):
    if n_q == idx:
        count += 1
        return
    for i in range(idx):
        for j in range(idx):
            if check[i][j]:
                continue
            for x in range(idx):
                for y in range(idx):
                    if (i == x or j == y or (abs(i-x) == abs(y-j))):
                        check[x][y] = True
            sumcnt = 0
            for k in range(idx):
                sumcnt += sum(check[k])
            if sumcnt == idx*idx:
                print('max')
                for x in range(idx):
                    for y in range(idx):
                        check[x][y] = False
                return -1
            a = findans(idx, n_q + 1, count)
            if a == -1:
                continue


N = int(sys.stdin.readline())
check = [[False]*N for i in range(N)]
count = 0
findans(N, 0, count)
for i in range(N):
    for j in range(N):
        if check[i][j] == True:
            print('1', end=' ')
        else:
            print('0', end=' ')
    print()
print(count)
