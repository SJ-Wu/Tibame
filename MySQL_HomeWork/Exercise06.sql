-- 01.請列出薪資比所有SALESMAN還低的員工
# step1. 找出所有salesman的員工薪資
-- select 
--     MIN(SAL)
-- from 
--     EMP
-- where JOB = 'SALESMAN';
# step2. 找出薪資比Step1還低的員工
select
    ENAME,
    SAL,
    JOB
from 
    EMP
where 
    SAL < (
    select 
        MIN(SAL)
    from 
        EMP
    where JOB = 'SALESMAN');
    
-- 02.請列出到職年(到職日之年)最早的兩年，那兩年到職的員工，並依到職日排序
# Step1. 列出所有員工的到職年(不重復)
select distinct
    YEAR(HIREDATE) HIREDATE
from 
    EMP
order by 
    YEAR(HIREDATE)
limit 2;
# Step2. 找出前兩年的員工
# Error Code: 1235. This version of MySQL doesn't yet support 'LIMIT & IN/ALL/ANY/SOME subquery'
-- select 
--     e.ENAME,
--     YEAR(e.HIREDATE) as Y1
-- from 
--     EMP e
--     where Y1 in (
--     select distinct
--         YEAR(HIREDATE)
--     from 
--         EMP
--     order by 
--         YEAR(HIREDATE)
--     limit 2);
select
    ENAME,
    HIREDATE
from (
    select distinct
        YEAR(HIREDATE) Y2
    from 
        EMP
    order by 
        YEAR(HIREDATE)
    limit 2) e2
    join EMP e on YEAR(e.HIREDATE) = e2.Y2
order by HIREDATE;

-- 03. 請列出主管的主管是KING的員工
# Step1. 列出員工與上級主管
select 
--     e.EMPNO, e.ENAME as L0,
--     e2.EMPNO, e2.ENAME as L1,
--     e3.EMPNO, e3.ENAME as L2
e.EMPNO, e.ENAME as L0
from
    EMP e
    left join EMP e2
        on e.MGR = e2.EMPNO
    left join EMP e3
        on e2.MGR = e3.EMPNO
where 
    e3.ENAME = 'KING'
order by
    e.EMPNO;

-- 04.請列出部門內員工薪資有3種薪資等級之部門名稱、部門所在地
# Step1. 將所有員工薪資分級並根據部門以及薪資等級分組
select
    sl.LEVEL,
    e.DEPTNO,
    IF(COUNT(*) >= 1, 1, 0) as EXT #將計數超過1以上的當作1以利後續操作
from 
    EMP e
    join SAL_LEVEL sl 
    on e.SAL between sl.SAL_MIN and sl.SAL_MAX
group by 
    e.DEPTNO,
    sl.LEVEL
order by
    DEPTNO,
    sl.LEVEL;
# Step2. 統計部門薪資等級是否有3種以上
select
-- COUNT(*),
-- e1.DEPTNO,
d.DNAME,
d.LOC
from
    (select
        sl.LEVEL,
        e.DEPTNO,
        IF(COUNT(*) >= 1, 1, 0) as EXT #將計數超過1以上的當作1以利後續操作
    from 
        EMP e
        join SAL_LEVEL sl 
        on e.SAL between sl.SAL_MIN and sl.SAL_MAX
    group by 
        e.DEPTNO,
        sl.LEVEL
    order by
        DEPTNO,
        sl.LEVEL) e1
    join DEPT d
    on d.DEPTNO = e1.DEPTNO
group by
e1.DEPTNO;

-- 05.請列出跟員工姓名最後一字元是S的員工同部門，該部門薪資最低的員工之部門名稱、姓名、薪資
# Step1. 找出最後一字元是S的員工
select
    DEPTNO,
    ENAME
from 
    EMP
where
    ENAME like '%s';
# Step2. 找出這些員工所在的部門
select
    d.DEPTNO
from 
    DEPT d
    join (
        select
            ENAME,
            DEPTNO
        from 
            EMP
        where
            ENAME like '%s') e
    on d.DEPTNO = e.DEPTNO;
# Step3. 找出部門薪資最低的員工
select 
    DNAME,
    ENAME,
    SAL
from 
    EMP e4
    join(
        select
            d.DNAME,
            MIN(SAL) MIN_SAL
        from 
            EMP e1
            join (
            select
                DEPTNO,
                ENAME
            from 
                EMP
            where
                ENAME like '%s') e2
            on e1.DEPTNO = e2.DEPTNO
            join DEPT d
            on e1.DEPTNO = d.DEPTNO
    group by
    e2.DEPTNO) e3
on e4.SAL = e3.MIN_SAL

    