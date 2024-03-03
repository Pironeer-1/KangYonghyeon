target=list(input().upper())
target_once=list(set(target))
count_list=[]
for i in target_once:
  x=target.count(i)
  count_list.append(x)
max_value=max(count_list)
if count_list.count(max_value)>1:
  print('?')
else:
  index=count_list.index(max_value)
  print(target_once[index])