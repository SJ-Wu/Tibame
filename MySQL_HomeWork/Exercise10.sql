-- 02.請授予使用者william 對資料庫EXAMPLE底下所有資料表的所有權限 
grant all
on EXAMPLE.*
to 'william'@'%'
with grant option;
-- 03.請撤銷william 對資料庫EXAMPLE底下所有資料表的所有權限
revoke all
on EXAMPLE.*
from 'william'@'%';