from urllib.request import urlopen
from urllib.request import urlretrieve
from urllib.parse import quote_plus
from bs4 import BeautifulSoup
from selenium import webdriver
import requests
import time

session = requests.session()
url = "https://edu.ssafy.com/comm/login/SecurityLoginForm.do"

# data = {
#     "id": "mixkio@naver.com",
#     "pwd": "zeit0486!@"
# }

# response = session.post(url, data=data)

# response.raise_for_status()

driver = webdriver.Chrome(
    executable_path=r'C:\Users\mixki\Downloads\chromedriver_win32\chromedriver.exe')
driver.get(url)

driver.find_element_by_id('userId').send_keys('mixkio@naver.com')
driver.find_element_by_id('userPwd').send_keys('zeit0486!@')
driver.find_element_by_class_name('form-btn').click()

baseurl = 'https://edu.ssafy.com/data/upload_files/crossUpload/openLrn/ebook/unzip/A2022033117374450500/index.html?startpage='
for j in range(1, 271):
    time.sleep(2)
    plusurl = str(j)
    url = baseurl + quote_plus(plusurl)

    # response = session.get(url)

    # response.raise_for_status()

    # driver = webdriver.Chrome(
    #     executable_path=r'C:\Users\mixki\Downloads\chromedriver_win32\chromedriver.exe')
    driver.get(url)
    soup = BeautifulSoup(driver.page_source)
    img = soup.select('background')
    n = 1
    imgurl = []

    for i in img:
        try:
            imgurl.append(i.attrs["src"])
        except KeyError:
            imgurl.append(i.attrs["data-src"])

    for i in imgurl:
        urlretrieve(i, "crawling/크롤링사진/" + str(n) + ".jpg")
        n += 1
        print(imgurl)
        if (n == 50):
            break

driver.close()
