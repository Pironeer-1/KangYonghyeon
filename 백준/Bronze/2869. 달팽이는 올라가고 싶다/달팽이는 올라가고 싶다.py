morning, night, tree = map(int,input().split())
x=(tree-night)/(morning-night)
if x==int(x):
  ##정수로 나눠진다면 내려오지 안고 그대로 올라간다
  print(int(x))
else:
  ##소숫점이있다면 올림해준다
  print(int(x)+1)