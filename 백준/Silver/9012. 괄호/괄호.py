T=int(input())
for _ in range(T):
  stack=[]
  check=list(input())
  for i in check:
    if i =='(':
      stack.append(i)
    elif i ==')':
      if len(stack)==0:
        print('NO')
        break
      else:
        stack.pop()
  else:
    if len(stack)==0:
      print('YES')
    else:
      print('NO')
