import sys
N = int(sys.stdin.readline())
arr = []
dic = {}
arr1 = set()
for i in range(N):
    arr.append(int(sys.stdin.readline()))
    if dic.get(arr[i]) == None:
        dic[arr[i]] = 1
    else:
        dic[arr[i]] += 1
for i in arr:
    if dic.get(i) == max(dic.values()):
        arr1.add(i)
arr.sort()
print(round(sum(arr)/N))
print(arr[int(N/2)])
if len(arr1) >= 2:
    arr1.remove(min(arr1))
    print(min(arr1))
else:
    print(arr1.pop())
print(arr[0]-arr[N-1])
