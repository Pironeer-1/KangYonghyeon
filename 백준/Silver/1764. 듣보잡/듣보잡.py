no_listen, no_see=map(int,input().split())
no_listen_people=set()
no_see_people=set()
for _ in range(0,no_listen+no_see):
  if _ < no_listen:
    no_listen_people.add(input())
  else:
    no_see_people.add(input())
no_listen_see_people=list(no_listen_people.intersection(no_see_people))
no_listen_see_people=sorted(no_listen_see_people)
print(len(no_listen_see_people))
for i in no_listen_see_people:
  print(i)