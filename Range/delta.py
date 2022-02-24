import sys

N = 10
map[[range(N)] for _ in range(N)]
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def recur(x, y):
    if x == N-1 and y == N-1:
        return
    for i in range(4):
        sx = x + dy[i]
        sy = y + dx[i]
        if sx > N-1 or sy > N-1 or sx < 0 or sy < 0:
            continue
    recur(sx, sy)
