-- 코드를 작성해주세요
SELECT ID ,EMAIL,FIRST_NAME,LAST_NAME
FROM DEVELOPERS D 
WHERE D.SKILL_CODE&(
    SELECT CODE
    FROM SKILLCODES 
    WHERE NAME='Python'
) OR
D.SKILL_CODE&(
    SELECT CODE
    FROM SKILLCODES 
    WHERE NAME='C#'
)
ORDER BY D.ID ASC

-- NULL과 비트연산을 하면 항상 NULL이다-> 이를 활용하기
-- DEVELOPERS의 SKILL_CODE와 PYTHON 코드를 비트 AND연산으로 비교해서 SKILL_CODE에 포함 하고 있을시 0보다 큰수를 반환후 해당 행 선택
-- 포함 X일시 000 즉, 0을 반환하면서 선택되지 않는다
