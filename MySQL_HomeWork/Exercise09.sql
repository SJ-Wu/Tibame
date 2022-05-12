select * from MEMBER;
-- 01. 請新建會員資料表MEMBER
create table MEMBER (
    ID int not null auto_increment comment '編號',
    USERNAME varchar(50) not null comment '帳號',
    PASSWORD varchar(50) not null comment '密碼',
    PASS bit(1) default 0 comment '帳號開通記號',
    CREATE_DATE datetime not null comment '建立日期',
    LAST_UPDATE_DATE datetime not null,
    primary key (ID)
);
-- 02. 請對資料表MEMBER的欄位PASSWORD之後加入一欄位
alter table MEMBER
add column NICKNAME varchar(50) not null comment '暱稱' after PASSWORD;
-- 03. 請修改資料表MEMBER的欄位
alter table MEMBER
modify column USERNAME varchar(100) not null,
modify column LAST_UPDATE_DATE datetime default (NOW()) comment '最後修改日期';
-- 04. 請將資料表MEMBER的欄位USERNAME設為唯一鍵
alter table MEMBER
add constraint UK_USERNAME unique key (USERNAME);
-- 05. 請將資料表MEMBER的欄位USERNAME的唯一鍵移除
alter table MEMBER
drop constraint UK_USERNAME;
-- 06. 請將資料表MEMBER的欄位CREATE_DATE移除
alter table MEMBER
drop column CREATE_DATE;
-- 07. 請新建資料表 MEMBER2, MEMBER3，2個資料表的結構和資料需要與資料表MEMBER一樣
create table MEMBER2 as select * from MEMBER;
create table MEMBER3 as select * from MEMBER;
-- 08. 請將資料表MEMBER2改名為MEMBER_HIS
alter table MEMBER2 rename to MEMBER_HIS;
-- 09. 請將資料表MEMBER3截斷(truncate)
truncate table MEMBER3;
-- 10. 請將資料表MEBER3的儲存引擎改為MyISAM
show engines;
alter table MEMBER3 engine MyISAM;
-- 11. 請將資料表MEMBER3移除
drop table MEMBER3;




