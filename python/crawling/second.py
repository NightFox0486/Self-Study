from urllib.request import urlopen
from urllib.request import urlretrieve
from urllib.parse import quote_plus
from bs4 import BeautifulSoup
from selenium import webdriver

search = input('Google : ')
url = f'https://www.google.com/search?q={quote_plus(search)}&tbm=isch&sa=X&ved=2ahUKEwie6drf9PHoAhVJHKYKHQYRD9EQ_AUoAXoECA0QAw&biw=1808&bih=975'

driver = webdriver.Chrome(
    executable_path=r'C:\Users\mixki\Desktop\JAva\python\crawling\chromedriver.exe')
driver.get(url)
for i in range(500):
    driver.execute_script("window.scrollBy(0,10000)")

html = driver.page_source
soup = BeautifulSoup(html)
img = soup.select('.rg_i.Q4LuWd.tx8vtf')
n = 1
imgurl = []

for i in img:
    try:
        imgurl.append(i.attrs["src"])
    except KeyError:
        imgurl.append(i.attrs["data-src"])

for i in imgurl:
    urlretrieve(i, "crawling/크롤링사진/" + search + str(n) + ".gif")
    n += 1
    print(imgurl)
    if (n == 50):
        break

driver.close()
