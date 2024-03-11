import sys

test_case = int(sys.stdin.readline())
list_a = []

for _ in range(test_case):
    x, y = map(int, sys.stdin.readline().split())
    list_a.append([x, y])
list_a.sort(key= lambda x:(x[0],x[1]))
for i in list_a:
  print(i[0],i[1])