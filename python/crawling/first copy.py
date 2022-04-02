from urllib.request import urlopen
from urllib.parse import quote_plus
from bs4 import BeautifulSoup
import requests

session = requests.session()
url = "https://edu.ssafy.com/comm/login/SecurityLoginForm.do"

data = {
    "id": "mixkio@naver.com",
    "pwd": "zeit0486!@"
}

response = session.post(url, data=data)

response.raise_for_status()

baseurl = 'https://edu.ssafy.com/data/upload_files/crossUpload/openLrn/ebook/unzip/A2022033117374450500/index.html?startpage='
for j in range(1, 271):
    plusurl = str(j)
    url = baseurl + quote_plus(plusurl)

    response = session.get(url)

    response.raise_for_status()

    #html = urlopen(url).read()
    soup = BeautifulSoup(response.text, 'html.parser')
    img = soup.find_all(class_='background')

    for i in img:
        imgurl = i['src']
        with urlopen(imgurl) as f:
            with open(plusurl+'.jpg', 'wb') as h:
                img = f.read()
                h.write(img)
        print(imgurl)

print('다운로드 완료')
