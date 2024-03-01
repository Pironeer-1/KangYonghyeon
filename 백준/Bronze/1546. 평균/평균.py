subjects=int(input())
score=list(map(int,input().split()))
max_score=max(score)

new_score=[]
for s in score:
  new_score.append(s/max_score*100)

mean=sum(new_score)/len(new_score)
print(f'{mean:.2f}')