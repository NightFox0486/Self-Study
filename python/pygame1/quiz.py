import pygame
import random
#기본 초기화 (반드시 해야 하는 것들)################################
pygame.init()

# 화면 크기 설정
screen_width = 480
screen_height = 640
screen = pygame.display.set_mode((screen_width, screen_height))

# 화면 타이틀 설정
pygame.display.set_caption("quiz game")

# FPS
clock = pygame.time.Clock()
####################################################################


# 1. 사용자 게임 초기화(배경 화면, 게임 이미지, 좌표 , 폰트 등)###################

# 배경 이미지 불러오기
background = pygame.image.load(
    "C:/Users/mixki/Desktop/JAva/python/pygame1/background.png")

# 캐릭터(스프라이트) 불러오기
character = pygame.image.load(
    "C:/Users/mixki/Desktop/JAva/python/pygame1/character.png")
character_size = character.get_rect().size  # 이미지 크기를 구해옴
character_width = character_size[0]  # 캐릭터 가로 크기
character_height = character_size[1]  # 캐릭터 세로 크기
character_x_pos = screen_width / 2 - character_width / 2  # 캐릭터 초기 x위치
character_y_pos = screen_height - character_height  # 캐릭터 초기 y위치

# 이동할 좌표
to_x = 0

# 이동 속도
character_speed = 0.6

# 적 캐릭터
enemy = pygame.image.load(
    "C:/Users/mixki/Desktop/JAva/python/pygame1/enemy.png")
enemy_size = enemy.get_rect().size
enemy_width = enemy_size[0]
enemy_height = enemy_size[1]
enemy_x_pos = random.randint(0, screen_width-enemy_width)
enemy_y_pos = 0

# 폰트 정의
game_font = pygame.font.Font(None, 40)

# 총 시간
total_time = 30

# 시작 시간
start_ticks = pygame.time.get_ticks()

# 이벤트 루프
running = True  # 게임 진행 상태
while running:
    dt = clock.tick(30)  # 게임화면의 초당 프레임 설정

    # 이벤트 처리 (키보드, 마우스 등)
    for event in pygame.event.get():  # 어떤 이벤트가 발생항였는지 확인
        if event.type == pygame.QUIT:  # 창이 닫히는 이벤트 확인
            running = False  # 게임 종료

        if event.type == pygame.KEYDOWN:  # 키가 눌려있는지 확인
            if event.key == pygame.K_LEFT:
                to_x -= character_speed
            elif event.key == pygame.K_RIGHT:
                to_x += character_speed

        if event.type == pygame.KEYUP:  # 키가 떼지면 정지
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                to_x = 0

    enemy_y_pos += 5

    if enemy_y_pos > screen_height:
        enemy_x_pos = random.randint(0, screen_width-enemy_width)
        enemy_y_pos = 0

    # 캐릭터 위치 정의
    character_x_pos += to_x * dt

    # 화면 경계값 처리
    if character_x_pos < 0:
        character_x_pos = 0
    elif character_x_pos > (screen_width - character_width):
        character_x_pos = screen_width - character_width

    # 충돌 처리를 위한 rect 정보 업데이트
    character_rect = character.get_rect()
    character_rect.left = character_x_pos
    character_rect.top = character_y_pos

    enemy_rect = enemy.get_rect()
    enemy_rect.left = enemy_x_pos
    enemy_rect.top = enemy_y_pos

    # 충돌 체크
    if character_rect.colliderect(enemy_rect):
        print("collision dectect")
        running = False

    #screen.fill((0, 0, 255))
    screen.blit(background, (0, 0))  # 배경 그리기

    screen.blit(character, (character_x_pos, character_y_pos))  # 캐릭터 그리기

    screen.blit(enemy, (enemy_x_pos, enemy_y_pos))  # 적 그리기

    elapsed_time = (pygame.time.get_ticks() - start_ticks) / 1000  # 경과시간 계산

    timer = game_font.render(
        str(int(total_time - elapsed_time)), True, (255, 255, 255))  # 타이머 계산

    screen.blit(timer, (10, 10))  # 타이머 표시

    # 시간 초과
    if total_time - elapsed_time <= 0:
        print("타임아웃")
        running = False

    pygame.display.update()  # 게임화면 다시그리기 (필수)

# 게임 종료후 잠시 대기
pygame.time.delay(2000)

pygame.quit()
