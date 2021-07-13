create sequence seq_blogger increment by 1 start with 1;

create table blogger (
        id number(11) not null primary key,
        email varchar2(30) not null unique,
        pw varchar2(20) not null,
        name varchar2(30) not null,
        phone varchar2(13),
        address varchar2(50)
);

INSERT INTO blogger VALUES(seq_blogger.nextval,'root@induk.ac.kr', 'cometrue','관리자', '9507620','korea');
INSERT INTO blogger VALUES(seq_blogger.nextval,'egyou@induk.ac.kr', 'cometrue','유응구', '9507625', 'korea');

select * from blogger;

select pw from blogger where email = 'egyou@induk.ac.kr';

update blogger set name='comso', phone='7777', address='nowon, seoul' where email='comso1@induk.ac.kr' and pw='cometrue';

delete from blogger where id = 23;

drop sequence seq_blogger;

drop table blogger;

