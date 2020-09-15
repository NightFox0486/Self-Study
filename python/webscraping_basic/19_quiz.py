from bs4 import BeautifulSoup
from selenium import webdriver
import time

url = ("http://daum.net")
headers = "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Whale/2.8.105.22 Safari/537.36"
options = webdriver.ChromeOptions()
options.add_argument(headers)
options.headless = True
browser = webdriver.Chrome(options=options)
browser.maximize_window()
browser.get(url)

browser.find_element_by_class_name("tf_keyword").send_keys("송파 헬리오시티")
browser.find_element_by_xpath(
    "//*[@id='daumSearch']/fieldset/div/div/button[2]").click()
time.sleep(1)
soup = BeautifulSoup(browser.page_source, "lxml")
elem = soup.find("div", attrs={"class": "wrap_tbl tbl_trade"})
data_rows = elem.find("tbody").find_all("tr")

for idx, row in enumerate(data_rows):
    print("======== 매물 {} ========".format(idx+1))
    print("거래 : "+row.find("td", attrs={"class": "col1"}
                           ).find("div", attrs={"class": "txt_ac"}).get_text())
    print("면적 : "+row.find("td", attrs={"class": "col2"}
                           ).find("div", attrs={"class": "txt_ac"}).get_text())
    print("가격 : "+row.find("td", attrs={"class": "col3"}
                           ).find("div", attrs={"class": "txt_ac"}).get_text())
    print("동 : "+row.find("td", attrs={"class": "col4"}
                          ).find("div", attrs={"class": "txt_ac"}).get_text())
    print("층 : "+row.find("td", attrs={"class": "col5"}
                          ).find("div", attrs={"class": "txt_ac"}).get_text())
