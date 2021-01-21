for i in range(1, 51):
    fname = str(i) + "주차.txt"
    with open(fname, "w", encoding="utf8") as quiz7:
        quiz7.write("- "+str(i)+" 주차 주간보고 -\n")
        quiz7.write("부서 : \n")
        quiz7.write("이름 : \n")
        quiz7.write("업무 요약 : \n")
