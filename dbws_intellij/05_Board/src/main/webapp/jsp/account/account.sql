create table login_test(
    l_id varchar2(30 char) primary key ,
    l_pw varchar2(30 char) not null ,
    l_name varchar2(30 char) not null
);

insert into login_test values ('jy1004', 'jy1004', 'jyjy');
insert into login_test values ('aa', 'aa', 'AAAA');

select * from login_test;