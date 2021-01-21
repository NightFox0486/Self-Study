from random import *
cnt = 0
for num in range(1, 51):
    min = int(random()*45+5)  # randrange(5, 51)
    #print("{0}번째 손님 (소요시간 : {1}분)".format(num, min))
    if 5 <= min <= 15:
        print("[0] {0}번째 손님 (소요시간 : {1}분)".format(num, min))
        cnt += 1
    else:
        print("[ ] {0}번째 손님 (소요시간 : {1}분)".format(num, min))
print("총 탑승 승객 : {0}분".format(cnt))
