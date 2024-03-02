start_num=list((input()))
if len(start_num)>1:
  answer=''.join(start_num)
else:
  answer='0'+''.join(start_num)
count=0
while True:
  start=0
  count+=1

  for num in start_num:
    start+=int(num)

  new_num=start_num[-1]+list(str(start))[-1]
  if answer==new_num:
    print(count)
    break
  else:
    start_num=new_num