# import sys
# print("Ptyhon", "Java")
# print("Ptyhon" + "Java")
# print("Ptyhon", "Java", sep=",")
# print("Ptyhon", "Java", sep=" vs ")
# print("Ptyhon", "Java", sep=",", end="?")
# print("question")

# print("Ptyhon", "Java", file=sys.stdout) #표준출력으로 처리
# print("Ptyhon", "Java", file=sys.stderr) #표준에러로 처리

# scores = {"수학": 0, "영어": 50, "코딩": 100}
# for subject, score in scores.items():
#     print(subject, score)
#     print(subject.ljust(8), str(score).rjust(4), sep=":")

# for num in range(1, 21):
#     print("대기번호 : " + str(num).zfill(3))

answer = input("아무 값이나 입력하세요 : ")  # input 사용시 항상 문자열
print("입력하신 값은 " + answer + "입니다.")
