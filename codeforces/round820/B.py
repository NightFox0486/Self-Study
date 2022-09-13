# from ast import For


# t = int(input())

# def decode(input):
#   return chr(input+ord('a')-1)

# for i in range(t):
#   answer = ''
#   n = input()
#   code = list(input())
#   for j in code:
#     if j == '0':
#       code.remove(j)
#     else:
#       answer += decode(int(code[j]))

for s in [*open(0)][2::2]:
    s = [*s[:-1]]
    r = ""
    while s:
        if (x := s.pop()) < "1":
            x = s[-2] + s[-1]
            s[-2:] = []
        r = chr(96 + int(x)) + r
    print(r)
