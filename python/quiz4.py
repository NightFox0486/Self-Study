from random import *
# eventlist = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
#             11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
eventlist = range(1, 21)
eventlist = list(eventlist)
shuffle(eventlist)
chicken = sample(eventlist, 1)
# print(eventlist)
eventlist.remove(chicken[0])
print("치킨당첨자 : " + str(chicken))
# print(eventlist)
shuffle(eventlist)
coffee = sample(eventlist, 2)
print("커피당첨자 : " + str(coffee))
