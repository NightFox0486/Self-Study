t = int(input())
for i in range(t):
  a, b, c = map(int, input().split())
  firstDistance = abs(a-1)
  if(b>c):
    secondDistance = abs(b-1)
  else:
    secondDistance = c-b + c - 1

  if(firstDistance < secondDistance):
    print(1)
  elif(firstDistance > secondDistance):
    print(2)
  else:
    print(3)