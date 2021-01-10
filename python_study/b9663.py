import sys


def findans(idx, n_q):
    global count, arr, arr1
    for i in range(idx):
        if idx == 1 and i > 0:
            return
        for j in range(idx):
            if check[i][j]:
                continue
            arr.append(i)
            arr1.append(j)
            for x in range(idx):
                for y in range(idx):
                    if (i == x or j == y or (abs(i-x) == abs(y-j))):
                        check[x][y] = True

            sumcnt = 0
            for k in range(idx):
                sumcnt += sum(check[k])
            if sumcnt == idx*idx or n_q == idx:
                if n_q == idx:
                    count += 1
                    for c in range(idx):
                        ee[arr[c]][arr1[c]] = 1
                    for a in range(idx):
                        for b in range(idx):
                            print(ee[a][b], end=' ')
                        print()
                    print('====================')
                for x in range(idx):
                    for y in range(idx):
                        check[x][y] = False
                        ee[x][y] = 0
                arr.clear()
                arr1.clear()
                return -1

            a = findans(idx, n_q + 1)
            if a == -1 and n_q != 1:
                return -1


N = int(sys.stdin.readline())
check = [[False]*N for i in range(N)]
ee = [[0]*N for i in range(N)]
count = 0
arr = []
arr1 = []
findans(N, 1)
print(count)
