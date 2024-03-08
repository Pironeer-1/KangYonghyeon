target=input()
croatia_alphabet=['c=','c-','dz=','d-','lj','nj','s=','z=']
for i in croatia_alphabet:
  if i in target:
    target=target.replace(i,'a')
print(len(target))