# class Unit:
#     def __init__(self, name, hp, speed):
#         self.name = name
#         self.hp = hp
#         self.speed = speed

#     def move(self, location):
#         print("[지상 유닛 이동]")
#         print("{0} : {1} 방향으로 이동합니다. [속도 {2}]"
#               .format(self.name, location, self.speed))


# class AttackUnit(Unit):
#     def __init__(self, name, hp, speed, damage):
#         Unit.__init__(self, name, hp, speed)
#         self.damage = damage

#     def attack(self, location):
#         print("{0} : {1} 방향으로 적군을 공격 합니다. [공격력 {2}]"
#               .format(self.name, location, self.damage))

#     def damaged(self, damage):
#         print("{0} : {1} 데미지를 입었습니다.".format(self.name, damage))
#         self.hp -= damage
#         print("{0} : 현재 체력은 {1} 입니다.".format(self.name, self.hp))
#         if self.hp <= 0:
#             print("{0} : 파괴되었습니다.".format(self.name))


# class Flyable:
#     def __init__(self, flying_speed):
#         self.flying_speed = flying_speed

#     def fly(self, name, location):
#         print("{0} : {1} 방향으로 날아갑니다. [속도 {2}]"
#               .format(name, location, self.flying_speed))


# class FlyableAttackUnit(AttackUnit, Flyable):
#     def __init__(self, name, hp, damage, flying_speed):
#         AttackUnit.__init__(self, name, hp, 0, damage)
#         Flyable.__init__(self, flying_speed)

#     def move(self, location):
#         print("[공중 유닛 이동]")
#         self.fly(self.name, location)


# class BuildingUnit(Unit):
#     def __init__(self, name, hp, location):
#         #Unit.__init__(self, name, hp, 0)
#         super().__init__(name, hp, 0)
#         self.location = location

class Unit:
    def __init__(self):
        print("Unit 생성자")


class Flyable:
    def __init__(self):
        print("Flyable 생성자")


class FlyableUnit(Unit, Flyable):
    def __init__(self):
        # super().__init__()
        Unit.__init__(self)
        Flyable.__init__(self)


dropship = FlyableUnit()
