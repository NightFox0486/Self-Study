import re
p = re.compile("ca.e")


def print_match(m):
    if m:
        print("m.group():", m.group())  # 일치하는 문자열 반환
        print("m.string:", m.string)  # 입력받은 문자열
        print("m.start():", m.start())  # 일치하는 문자열의 시작 index
        print("m.end():", m.end())  # 일치하는 문자열의 끝 index
        print("m.span():", m.span())  # 일치하는 문자열의 시작과 끝 index
    else:
        print("매칭되지 않음")


# m = p.match("care less")  # 처음부터 일치하는지 확인
# print_match(m)

# m = p.search("good care")  # 주어진 문자열안에 있는지 확인
# print_match(m)

lst = p.findall("careless good care cafe")
print(lst)
