def std_weight(height, gender):
    if gender == "남자":
        return round(((height*height*22)/10000), 2)
    elif gender == "여자":
        return round(((height*height*21)/10000), 2)
    else:
        print("입력값을 다시 확인해주세요.")


height = int(input("키를 입력해주세요 "))
gender = input("성별를 입력해주세요 ")
print("키 {0}cm {1}의 표준 체중은 {2}kg 입니다."
      .format(height, gender, std_weight(height, gender)))
