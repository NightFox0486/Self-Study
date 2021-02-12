li = list(map(int, input()))
li.sort(reverse=True)
result = 0
for i in range(len(li)):
    result += li[i]
    if i != len(li)-1:
        result *= 10
print(result)
