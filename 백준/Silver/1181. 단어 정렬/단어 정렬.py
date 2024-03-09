test_case=int(input())
random_list=[]
for _ in range(test_case):
  word=input()
  if word not in random_list:
    random_list.append(word)
    
sorted_list=sorted(random_list)
sorted_list=sorted(sorted_list,key=len)
for i in sorted_list:
  print(i)