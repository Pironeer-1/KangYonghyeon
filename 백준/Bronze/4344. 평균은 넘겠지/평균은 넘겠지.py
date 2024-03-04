test_case=int(input())
for _ in range(test_case):
  target_list=input().split()
  member=target_list[0]
  score=list(map(int,target_list[1:]))
  avg=sum(score)/len(score)
  over_score=[]
  for i in score:
    if i >avg:
      over_score.append(i)
  percent=round(len(over_score)/len(score)*100,3)
  print(str(percent)+'%')