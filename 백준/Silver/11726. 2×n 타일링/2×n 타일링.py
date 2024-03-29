n=int(input())
sol={}
sol[1]=1
sol[2]=2
for i in range(3,n+1):
  sol[i]=(sol[i-1]+sol[i-2])%10007
print(sol[n])
