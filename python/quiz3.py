url = "http://google.com"
curl = url.replace("http://", "")
seed = curl[:curl.index(".")]
pwr = seed[:3]+str(len(seed))+str(seed.count('e'))+"!"
print(f"{url}의 비밀번호는 {pwr}입니다.")
