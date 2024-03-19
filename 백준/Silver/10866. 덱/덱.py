import sys
def push_front(deck,x):
  deck.insert(0,int(x))
  return deck

def push_back(deck,x):
  deck.append(int(x))
  return deck

def pop_front(deck):
  if len(deck)==0:
    print(-1)
  else:
    print(deck.pop(0)) #print가 필요할까?
  return deck

def pop_back(deck):
  if len(deck)==0:
    print(-1)
  else:
    print(deck.pop(len(deck)-1)) #print가 필요할까?
  return deck

def size(deck):
  print(len(deck))

def empty(deck):
  if len(deck)==0:
    print(1)
  else:
    print(0)

def front(deck):
  if len(deck)==0:
    print(-1)
  else:
    print(deck[0])

def back(deck):
  if len(deck)==0:
    print(-1)
  else:
    print(deck[-1])
T=int(sys.stdin.readline())
deck=[]
for _ in range(T):
  command=sys.stdin.readline().split()
  if len(command)>1:
    if command[0]=='push_back':
      push_back(deck,command[1])
    elif command[0]=='push_front':
      push_front(deck,command[1])
  else:
    if command[0]=='front':
      front(deck)
    elif command[0]=='back':
      back(deck)
    elif command[0]=='size':
      size(deck)
    elif command[0]=='empty':
      empty(deck)
    elif command[0]=='pop_back':
      pop_back(deck)
    elif command[0]=='pop_front':
      pop_front(deck)