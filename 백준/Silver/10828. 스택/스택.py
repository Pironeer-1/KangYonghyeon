import sys
def push(stack,x):
  stack.insert(0,int(x))
  return stack
def pops(stack):
  if len(stack)==0:
    print(-1)
  else:
    print(stack.pop(0))
  return stack
def size(stack):
  print(len(stack))
def empty(stack):
  if len(stack)==0:
    print(1)
  else:
    print(0)
def top(stack):
  if len(stack)==0:
    print(-1)
  else:
    print(stack[0])
stack=[]
test=int(sys.stdin.readline())
for _ in range(test):
  commands=sys.stdin.readline().split()
  if len(commands)>1:
    if commands[0]=='push':
      push(stack,commands[1])
  else:
    if commands[0]=='pop':
      pops(stack)
    elif commands[0]=='top':
      top(stack)
    elif commands[0]=='size':
      size(stack)
    elif commands[0]=='empty':
      empty(stack)