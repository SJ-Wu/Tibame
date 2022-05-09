-- 01.請列出部門編號、部門平均薪資，只顯示部門平均薪資大於2500的部門
select
    DEPTNO,
    AVG(SAL) as AVG_SAL
from EMP
group by 
    DEPTNO
    having AVG_SAL > 2500;

-- 02.請列出到職年、到職年當年人數，只顯示到職年當年人數等於1的資料
select 
    YEAR(HIREDATE),
    COUNT(*) as PEOPLE
from EMP
group by 1
having
    PEOPLE = 1;

-- 03.請列出各部門編號、部門每月發出薪資總和，只顯示部門每月發出薪資總和小於10000的部門，並依部門編號遞減排序
select 
    DEPTNO,
    SUM(SAL) as SUM_SAL
from EMP
group by
    DEPTNO
having 
    SUM_SAL < 10000
order by
    DEPTNO desc;
    
-- 04.請列出職稱、該職稱平均薪資、該職稱人數，只顯示職稱平均薪資大於2000且職稱人數小於2的資料
select
    JOB,
    AVG(SAL) as AVG_SAL,
    COUNT(*) as PEOPLE
from EMP
group by
    JOB
having 
    AVG_SAL > 2000 and PEOPLE < 2;

-- 05.請列出部門編號、部門最低薪資、部門最高薪資，且過濾掉最低薪資大於1200的資料
select 
    DEPTNO,
    MIN(SAL) as MIN_SAL,
    MAX(SAL)
from EMP
group by
    DEPTNO
having
    MIN_SAL <= 1200
order by 
    DEPTNO;
