delivery=int(input())
take=0
while delivery>=0:
  if delivery%5==0:
    take+=delivery//5
    print(take)
    break
  delivery-=3
  take+=1
else:
  print(-1)