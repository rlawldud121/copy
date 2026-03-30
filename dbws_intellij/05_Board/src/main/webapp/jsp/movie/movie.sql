create table movie_test(
    m_no number(3) primary key ,
    m_title varchar2(30 char) not null ,
    m_actor varchar2(30 char) not null ,
    m_img varchar2(200 char) not null ,
    m_story varchar2(500 char) not null
);

create sequence movie_test_seq;

insert into movie_test values (movie_test_seq.nextval, '매트릭스', '키아누', 'a.jpg','가상세계이야기~^^');
insert into movie_test values (movie_test_seq.nextval, '컨저링', '대충귀신들', 'b.jpg','귀신들린집');
insert into movie_test values (movie_test_seq.nextval, '인터스텔라', '매튜 맥커너히', 'c.jpg', '우주와 시간 여행 이야기');
insert into movie_test values (movie_test_seq.nextval, '인셉션', '레오나르도 디카프리오', 'd.jpg', '꿈 속의 꿈을 설계하는 이야기');
insert into movie_test values (movie_test_seq.nextval, '어벤져스', '로버트 다우니 주니어', 'e.jpg', '히어로들이 모여 지구를 구하는 이야기');
insert into movie_test values (movie_test_seq.nextval, '타이타닉', '레오나르도 디카프리오', 'f.jpg', '침몰하는 배에서의 사랑 이야기');
insert into movie_test values (movie_test_seq.nextval, '겨울왕국', '엘사', 'g.jpg', '얼음 마법을 가진 공주의 이야기');
insert into movie_test values (movie_test_seq.nextval, '기생충', '송강호', 'h.jpg', '빈부격차를 다룬 사회 풍자 이야기');
insert into movie_test values (movie_test_seq.nextval, '범죄도시', '마동석', 'i.jpg', '강력반 형사의 범죄 소탕 이야기');
insert into movie_test values (movie_test_seq.nextval, '알라딘', '윌 스미스', 'j.jpg', '램프의 요정과 모험 이야기');
insert into movie_test values (movie_test_seq.nextval, '조커', '호아킨 피닉스', 'k.jpg', '광대의 비극적인 탄생 이야기');
insert into movie_test values (movie_test_seq.nextval, '스파이더맨', '톰 홀랜드', 'l.jpg', '평범한 학생의 히어로 성장 이야기');

select * from movie_test;