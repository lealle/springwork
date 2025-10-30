create SEQUENCE seq_boardtest nocache;

create table boardtest(
    boardno number PRIMARY key,
    title VARCHAR2(50),
    writer VARCHAR2(20),
    content VARCHAR2(500)
);

insert into boardtest values(seq_boardtest.nextval, '제목1', '나핑클','내용1');
insert into boardtest values(seq_boardtest.nextval, '제목2', '이빛나','내용2');

commit;