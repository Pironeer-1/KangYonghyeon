test_case=int(input())
counter=0
for _ in range(test_case):
  target= list(input())
  index=[]
  for i in range(len(target)):
    if i == len(target)-1:
      index.append(i)
    elif i < len(target)-1:
      if target[i]!=target[i+1]:
        index.append(i)
  change_case=[target[j] for j in index]
  if all(change_case.count(k) ==1 for k in change_case):
    counter+=1
print(counter)