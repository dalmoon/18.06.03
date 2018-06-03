INSERT INTO customer " +
			"VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?)


CREATE TABLE customer(
    NO INT , --번호(시퀀스 사용)
    id varchar2(20) primary key, --고객아이디
    NAME VARCHAR2(20), --고객이름
    age NUMBER(3), --고객나이
    tel VARCHAR2(30), --고객연락처
    addr VARCHAR2(50)--고객주소
)

drop table    customer
create sequence CUSTOMER_SEQ nocache
insert into customer values(CUSTOMER_SEQ.NEXTVAL,'jang','장희정',20,'02-222-8282','서울시 강남구')
commit;


drop sequence    CUSTOMER_SEQ


select * from customer