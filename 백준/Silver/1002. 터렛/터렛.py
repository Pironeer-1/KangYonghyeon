import math
T=int(input())
for _ in range(T):
  x_1,y_1,r_1,x_2,y_2,r_2=map(int,input().split())
  length=math.sqrt((x_1-x_2)**2+(y_1-y_2)**2)
  R=r_1+r_2
  if length==0 and r_1==r_2:
    print(-1)
  elif length>max(r_1,r_2):
    if length==R:
      print(1)
    elif length<R:
      print(2)
    elif length>R:
      print(0)
  elif length<=max(r_1,r_2):
    if length+min(r_1,r_2)==max(r_1,r_2):
      print(1)
    elif length+min(r_1,r_2)<max(r_1,r_2):
      print(0)
    elif length+min(r_1,r_2)>max(r_1,r_2):
      print(2)