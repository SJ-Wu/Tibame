-- select * from EMP;
-- select * from DEPT;
-- select * from SAL_LEVEL;

-- Q1 請列出所有員工的員工編號、姓名、職稱、部門編號及部門名稱
select 
    e.EMPNO,
    e.ENAME,
    e.JOB,
    e.DEPTNO,
    d.DNAME
from EMP e
    join
        DEPT d
        on e.DEPTNO = d.DEPTNO;

-- Q2 請列出所有部門編號為30 且 職稱為"SALESMAN"之部門名稱、員工姓名、獎金
select 
    d.DNAME,
    e.ENAME,
    e.COMM
from EMP e
    join 
        DEPT d
        on d.DEPTNO = 30
where e.JOB = 'SALESMAN';

-- Q3 請列出薪水等級為"B"的員工之員工編號、員工姓名、薪資
select 
    e.EMPNO,
    e.ENAME,
    e.SAL,
    sl.LEVEL
from 
    EMP e
    join DEPT d on e.DEPTNO = d.DEPTNO
    -- natural join DEPT
    join SAL_LEVEL sl on e.SAL between sl.SAL_MIN and sl.SAL_MAX
where sl.LEVEL = 'B'; 
    
-- 04 請列出部門編號、部門名稱及部門人數
select
    d.DEPTNO,
    d.DNAME,
    COUNT(*)
from
    DEPT d
    join EMP e
        on e.DEPTNO = d.DEPTNO
group by
    d.DEPTNO,
    d.DNAME;
    
-- 05.請列出每個主管之姓名、直屬下屬人數、直屬下屬平均薪資，並依直屬下屬人數遞減、主管姓名遞增排序
select
    e2.ENAME as MGRNAME,
    COUNT(*) as EMPCNT,
    AVG(e.SAL) as EMPAVGSAL
from
    EMP e
    left join EMP e2
        on e.MGR = e2.EMPNO
where e.MGR is not null
group by
    e2.ENAME
order by
    EMPCNT desc,
    MGRNAME;