def recur(n, s, e, v):
    #탈출 조건
    if n == 0:
        return
    
    #명령어
    #재귀호출
    recur(n-1,s,v,e)
    print(str(s)+" "+str(e))
    recur(n-1, v,e,s)
    
n = int(input())

print((2 ** n)-1)
recur(n,1,3,2)

#재귀함수 형태

def recur():
    #종료 조건 or 가지치기
    if ...:
        return
    
    #명령어
    print(??)
    
    #재귀 호출
    recur()
    
    #명령어
    print(??)
    
def (recur(n)):
    if n == 0:
        return
    
    print(n) #역방향
    recur(n-1)
    print(n) # 정방향
    
    #recur(n//2)
    #print(n%2)
    
recur(5)