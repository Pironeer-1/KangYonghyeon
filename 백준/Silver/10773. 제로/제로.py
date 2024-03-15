case=int(input())
numbers=[]
for _ in range(case):
  num=int(input())
  if num==0:
    del numbers[len(numbers)-1]
  else:
    numbers.append(num)
print(sum(numbers))