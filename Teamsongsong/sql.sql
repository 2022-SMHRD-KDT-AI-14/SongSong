drop table member;
create table member
(id varchar2(200) not null, 
pw varchar2(200) not null, 
name varchar2(200) not null, 
score number(38),
constraint member_id_pk primary key(id));



drop table musiclist;
create table musiclist
(singer varchar2(300) not null,
title varchar2(300) not null,
path varchar2(500) not null,
diff varchar2(300) not null,
constraint musiclist_path_pk primary key(path),
constraint musiclist_diff_ck check(diff in('상','중','하'))
);	


select * from member;
select * from musiclist;

--select path from musiclist where diff ='상' order by RAND()
--select path from (select * from musiclist where diff = '상' order by dbms_random.value) where rownum <= 1;

select *from musiclist where singer ='CAMO'
select *from musiclist where singer ='카라'


delete from musiclist where singer ='레드벨뱃'

update musiclist
set title ='MYRHYTHM'
path= 'C:/Users/smhrd/Desktop/MP3/music/레드벨벳 - MYRHYTHM'
where singer ='레드벨벳'


insert into musiclist
values('탑현','호랑수월가','C:/Users/smhrd/Desktop/MP3/music/탑현 - 호랑수월가.mp3','상');
insert into musiclist
values('(여자)아이들','TOMBOY','C:/Users/smhrd/Desktop/MP3/music/여자아이들 - TOMBOY.mp3','상');
insert into musiclist
values('IVE(아이브)','ELEVEN','C:/Users/smhrd/Desktop/MP3/music/아이브 - ELEVEN.mp3','상');
insert into musiclist
values('스테이시','RUN2U','C:/Users/smhrd/Desktop/MP3/music/스테이씨 - RUN2U.mp3','상');
insert into musiclist
values('악동뮤지션','어떻게이별까지사랑하겠어널사랑하는거지','C:/Users/smhrd/Desktop/MP3/music/악동뮤지션 - 어떻게이별까지사랑하겠어널사랑하는거지.mp3','상');
insert into musiclist
values('잔나비','주저하는연인들을위해','C:/Users/smhrd/Desktop/MP3/music/잔나비 - 주저하는연인들을위해.mp3','상');
insert into musiclist
values('유리상자','사랑해도될까요','C:/Users/smhrd/Desktop/MP3/music/유리상자 - 사랑해도될까요.mp3','상');
insert into musiclist
values('방탄소년단','MAGICSHOP','C:/Users/smhrd/Desktop/MP3/music/방탄소년단 - MAGICSHOP.mp3','상');
insert into musiclist
values('데이식스','행복했던날들이었다','C:/Users/smhrd/Desktop/MP3/music/데이식스 - 행복했던날들이었다.mp3','상');
insert into musiclist
values('CAMO','CAMO - LIFEISWET','C:/Users/smhrd/Desktop/MP3/music/카모 - LIFEISWET.mp3','상');
insert into musiclist
values('빅뱅','봄여름가을겨울','C:/Users/smhrd/Desktop/MP3/music/빅뱅 - 봄여름가을겨울.mp3','중');
insert into musiclist
values('레드벨뱃','FEELMYRHYTHM','C:/Users/smhrd/Desktop/MP3/music/레드벨벳 - MYRHYTHM.mp3','중');
insert into musiclist
values('멜로망스','취중고백','C:/Users/smhrd/Desktop/MP3/music/멜로망스 - 취중고백.mp3','중');
insert into musiclist
values('이무진','신호등','C:/Users/smhrd/Desktop/MP3/music/이무진 - 신호등.mp3','중');
insert into musiclist
values('아이유','드라마','C:/Users/smhrd/Desktop/MP3/music/아이유 - 드라마.mp3','중');
insert into musiclist
values('싸이','THATTHAT','C:/Users/smhrd/Desktop/MP3/music/싸이 - THATTHAT.mp3','중');
insert into musiclist
values('임영웅','사랑은늘도망가','C:/Users/smhrd/Desktop/MP3/music/임영웅 - 사랑은늘도망가.mp3','중');
insert into musiclist
values('소코도모','회전목마','C:/Users/smhrd/Desktop/MP3/music/소코도모 - 회전목마.mp3','중');
insert into musiclist
values('방탄소년단','BUTTER','C:/Users/smhrd/Desktop/MP3/music/방탄소년단 - BUTTER.mp3','중');
insert into musiclist
values('방탄소년단','DYNAMITE','C:/Users/smhrd/Desktop/MP3/music/방탄소년단 - DYNAMITE.mp3','중');
insert into musiclist
values('방탄소년단','FIRE','C:/Users/smhrd/Desktop/MP3/music/방탄소년단 - FIRE.mp3','중');
insert into musiclist
values('여자친구','밤','C:/Users/smhrd/Desktop/MP3/music/여자친구 - 밤.mp3','중');
insert into musiclist
values('트와이스','TT','C:/Users/smhrd/Desktop/MP3/music/트와이스 - TT.mp3','중');
insert into musiclist
values('슈퍼주니어','SORRYSORRY','C:/Users/smhrd/Desktop/MP3/music/슈퍼주니어 - SORRYSORRY.mp3','하');
insert into musiclist
values('샤이니','링딩동','C:/Users/smhrd/Desktop/MP3/music/샤이니 - 링딩동.mp3','하');
insert into musiclist
values('샤이니','루시퍼','C:/Users/smhrd/Desktop/MP3/music/샤이니 - 루시퍼.mp3','하');
insert into musiclist
values('2PM','HEARTBEAT','C:/Users/smhrd/Desktop/MP3/music/2PM - HEARTBEAT.mp3','하');
insert into musiclist
values('원더걸스','TELLME','C:/Users/smhrd/Desktop/MP3/music/원더걸스 - TELLME.mp3','하');
insert into musiclist
values('원더걸스','NOBODY','C:/Users/smhrd/Desktop/MP3/music/원더걸스 - NOBODY.mp3','하');
insert into musiclist
values('다비치','8282','C:/Users/smhrd/Desktop/MP3/music/다비치 - 8282.mp3','하');
insert into musiclist
values('카라','미스터','C:/Users/smhrd/Desktop/MP3/music/카라 - MISTER.mp3','하');
insert into musiclist
values('아이유','좋은날','C:/Users/smhrd/Desktop/MP3/music/아이유 - 좋은날.mp3','하');
insert into musiclist
values('엑소','으르렁','C:/Users/smhrd/Desktop/MP3/music/엑소 - 으르렁.mp3','하');
insert into musiclist
values('소녀시대','GEE','C:/Users/smhrd/Desktop/MP3/music/소녀시대 - GEE.mp3','하');
insert into musiclist
values('소녀시대','소원을말해봐','C:/Users/smhrd/Desktop/MP3/music/소녀시대 - 소원을말해봐.mp3','하');
insert into musiclist
values('비','깡','C:/Users/smhrd/Desktop/MP3/music/비 - 깡.mp3','하');
insert into musiclist
values('청하','벌써12시','C:/Users/smhrd/Desktop/MP3/music/청하 - 벌써12시.mp3','하');
insert into musiclist
values('SS501','URMAN','C:/Users/smhrd/Desktop/MP3/music/SS501 - URMAN.mp3','하');
insert into musiclist
values('거미','YOUAREMYEVERYTHING','C:/Users/smhrd/Desktop/MP3/music/거미 - YOUAREMYEVERYTHING.mp3','하');
insert into musiclist
values('드림하이','DREAMHIGH','C:/Users/smhrd/Desktop/MP3/music/드림하이 - DREAMHIGH.mp3','하');
insert into musiclist
values('린','MYDESTINY','C:/Users/smhrd/Desktop/MP3/music/린 - MYDESTINY.mp3','하');
insert into musiclist
values('버스커버스커','벚꽃엔딩','C:/Users/smhrd/Desktop/MP3/music/버스커버스커 - 벚꽃엔딩.mp3','하');
insert into musiclist
values('백지영','총맞은것처럼','C:/Users/smhrd/Desktop/MP3/music/백지영 - 총맞은것처럼.mp3','하');
insert into musiclist
values('브레이브걸스','롤린','C:/Users/smhrd/Desktop/MP3/music/브레이브걸스 - 롤린.mp3','하');
insert into musiclist
values('비오','COUNTINGSTARS','C:/Users/smhrd/Desktop/MP3/music/비오 - COUNTINGSTARS.mp3','하');
insert into musiclist
values('빅뱅','판타스틱베이비','C:/Users/smhrd/Desktop/MP3/music/빅뱅 - 판타스틱베이비.mp3','하');
insert into musiclist
values('사이먼도미닉','SIMONDOMINIC','C:/Users/smhrd/Desktop/MP3/music/사이먼도미닉 - SIMONDOMINIC.mp3','하');
insert into musiclist
values('싸이','강남스타일','C:/Users/smhrd/Desktop/MP3/music/싸이 - 강남스타일.mp3','하');
insert into musiclist
values('씨엔블루','외톨이야','C:/Users/smhrd/Desktop/MP3/music/씨엔블루 - 외톨이야.mp3','하');
insert into musiclist
values('여자친구','시간을달려서','C:/Users/smhrd/Desktop/MP3/music/여자친구 - 시간을달려서.mp3','하');
insert into musiclist
values('오렌지캬라멜','까탈레나','C:/Users/smhrd/Desktop/MP3/music/오렌지캬라멜 - 까탈레나.mp3','하');
insert into musiclist
values('지코','아무노래','C:/Users/smhrd/Desktop/MP3/music/지코 - 아무노래.mp3','하');
insert into musiclist
values('태연','사계','C:/Users/smhrd/Desktop/MP3/music/태연 - 사계.mp3','하');
insert into musiclist
values('투애니원','내가제일잘나가','C:/Users/smhrd/Desktop/MP3/music/투애니원 - 내가제일잘나가.mp3','하');
insert into musiclist
values('티맥스','파라다이스','C:/Users/smhrd/Desktop/MP3/music/티맥스 - 파라다이스.mp3','하');
insert into musiclist
values('티아라','롤리폴리','C:/Users/smhrd/Desktop/MP3/music/티아라 - 롤리폴리.mp3','하');
insert into musiclist
values('휘성','결혼까지생각했어','C:/Users/smhrd/Desktop/MP3/music/휘성 - 결혼까지생각했어.mp3','하');
insert into musiclist
values('싸이','강남스타일','C:/Users/smhrd/Desktop/MP3/music/싸이 - 강남스타일.mp3','하');
insert into musiclist
values('김연자','아모르파티','C:/Users/smhrd/Desktop/MP3/music/김연자 - 아모르파티.mp3','중');
insert into musiclist
values('디핵','OHAYOMYNIGHTOHAYOMYNIGHT','C:/Users/smhrd/Desktop/MP3/music/디핵 - OHAYOMYNIGHTOHAYOMYNIGHT.mp3','중');
insert into musiclist
values('박효신','눈의꽃','C:/Users/smhrd/Desktop/MP3/music/박효신 - 눈의꽃.mp3','중');
insert into musiclist
values('백예린','SQUARE','C:/Users/smhrd/Desktop/MP3/music/백예린 - SQUARE.mp3','중');
insert into musiclist
values('버즈','나에게로떠나는여행','C:/Users/smhrd/Desktop/MP3/music/버즈 - 나에게로떠나는여행.mp3','중');
insert into musiclist
values('볼빨간사춘기','나의사춘기에게','C:/Users/smhrd/Desktop/MP3/music/볼빨간사춘기 - 나의사춘기에게.mp3','중');
insert into musiclist
values('비투비','무비','C:/Users/smhrd/Desktop/MP3/music/비투비 - 무비.mp3','중');
insert into musiclist
values('소녀온탑','같은곳에서','C:/Users/smhrd/Desktop/MP3/music/소녀온탑 - 같은곳에서.mp3','중');
insert into musiclist
values('아이브','LOVEDIVE','C:/Users/smhrd/Desktop/MP3/music/아이브 - LOVEDIVE.mp3','중');
insert into musiclist
values('아이유','CELEBRITY','C:/Users/smhrd/Desktop/MP3/music/아이유 - CELEBRITY.mp3','중');
insert into musiclist
values('에일리','첫눈처럼너에게가겠다','C:/Users/smhrd/Desktop/MP3/music/에일리 - 첫눈처럼너에게가겠다.mp3','중');
insert into musiclist
values('엑소','중독','C:/Users/smhrd/Desktop/MP3/music/엑소 - 중독.mp3','중');
insert into musiclist
values('워너원','ENERGETIC','C:/Users/smhrd/Desktop/MP3/music/워너원 - ENERGETIC.mp3','중');
insert into musiclist
values('윤종신','좋니','C:/Users/smhrd/Desktop/MP3/music/윤종신 - 좋니.mp3','중');
insert into musiclist
values('인크레더블','오빠차','C:/Users/smhrd/Desktop/MP3/music/인크레더블 - 오빠차.mp3','중');
insert into musiclist
values('전미도','사랑하게될줄알았어','C:/Users/smhrd/Desktop/MP3/music/전미도 - 사랑하게될줄알았어.mp3','중');
insert into musiclist
values('태양','눈코입','C:/Users/smhrd/Desktop/MP3/music/태양 - 눈코입.mp3','중');
insert into musiclist
values('태연','WHY','C:/Users/smhrd/Desktop/MP3/music/태연 - WHY.mp3','중');
insert into musiclist
values('폴킴','모든날모든순간','C:/Users/smhrd/Desktop/MP3/music/폴킴 - 모든날모든순간.mp3','중');
insert into musiclist
values('하이라이트','얼굴찌푸리지말아요','C:/Users/smhrd/Desktop/MP3/music/하이라이트 - 얼굴찌푸리지말아요.mp3','중');
insert into musiclist
values('PL','ONALR','C:/Users/smhrd/Desktop/MP3/music/PL - ONALR.mp3','상');
insert into musiclist
values('다비치','너에게못했던내마지막말은','C:/Users/smhrd/Desktop/MP3/music/다비치 - 너에게못했던내마지막말은.mp3','상');
insert into musiclist
values('미란이','ACHOO','C:/Users/smhrd/Desktop/MP3/music/미란이 - ACHOO.mp3','상');
insert into musiclist
values('박재범','ALLIWANNADO','C:/Users/smhrd/Desktop/MP3/music/박재범 - ALLIWANNADO.mp3','상');
insert into musiclist
values('박효신','기억속의먼그대에게','C:/Users/smhrd/Desktop/MP3/music/박효신 - 기억속의먼그대에게.mp3','상');
insert into musiclist
values('버스커버스커','향수','C:/Users/smhrd/Desktop/MP3/music/버스커버스커 - 향수.mp3','상');
insert into musiclist
values('수란','오늘취하면','C:/Users/smhrd/Desktop/MP3/music/수란 - 오늘취하면.mp3','상');
insert into musiclist
values('스윙스','UPGRADE2020','C:/Users/smhrd/Desktop/MP3/music/스윙스 - UPGRADE2020.mp3','상');
insert into musiclist
values('스탠딩에그','사랑하는너에게','C:/Users/smhrd/Desktop/MP3/music/스탠딩에그 - 사랑하는너에게.mp3','상');
insert into musiclist
values('양다일','고백','C:/Users/smhrd/Desktop/MP3/music/양다일 - 고백.mp3','상');
insert into musiclist
values('오반','진짜를꺼내봐','C:/Users/smhrd/Desktop/MP3/music/오반 - 진짜를꺼내봐.mp3','상');
insert into musiclist
values('윤건','너도그냥날놓아주면돼','C:/Users/smhrd/Desktop/MP3/music/윤건 - 너도그냥날놓아주면돼.mp3','상');
insert into musiclist
values('이승기','사랑이술을가르쳐','C:/Users/smhrd/Desktop/MP3/music/이승기 - 사랑이술을가르쳐.mp3','상');
insert into musiclist
values('임재현','사랑에연습이있었다면','C:/Users/smhrd/Desktop/MP3/music/임재현 - 사랑에연습이있었다면.mp3','상');
insert into musiclist
values('장범준','잠이오질않네요','C:/Users/smhrd/Desktop/MP3/music/장범준 - 잠이오질않네요.mp3','상');
insert into musiclist
values('정키','잊혀지다','C:/Users/smhrd/Desktop/MP3/music/정키 - 잊혀지다.mp3','상');
insert into musiclist
values('정효빈','이제는어떻게사랑을하나요','C:/Users/smhrd/Desktop/MP3/music/정효빈 - 이제는어떻게사랑을하나요.mp3','상');
insert into musiclist
values('주시크','아무래도난','C:/Users/smhrd/Desktop/MP3/music/주시크 - 아무래도난.mp3','상');
insert into musiclist
values('주시크','너를생각해','C:/Users/smhrd/Desktop/MP3/music/주시크 - 너를생각해.mp3','상');
insert into musiclist
values('첸','사월이지나면우리헤어져요','C:/Users/smhrd/Desktop/MP3/music/첸 - 사월이지나면우리헤어져요.mp3','상');
insert into musiclist
values('태연','들불','C:/Users/smhrd/Desktop/MP3/music/태연 - 들불.mp3','상');