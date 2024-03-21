T=int(input())
un_people=list(map(int,input().split()))
order_people=sorted(un_people)
time=0
for i in range(T):
  k=T-i
  time+=order_people[i]*k
print(time)