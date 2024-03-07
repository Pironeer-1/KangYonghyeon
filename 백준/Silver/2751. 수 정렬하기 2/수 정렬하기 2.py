import sys
test_case=int(input())
array=[]
for _ in range(test_case):
  array.append(int(sys.stdin.readline()))
answer=sorted(array,reverse=False)
for i in answer:
  print(i)