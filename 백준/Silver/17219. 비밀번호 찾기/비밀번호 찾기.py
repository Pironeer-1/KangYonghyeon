M,N=map(int,input().split())
kyungmin={}
for _ in range(M):
  key,value=input().split()
  kyungmin[key]=value
for _ in range(N):
  print(kyungmin[input()])