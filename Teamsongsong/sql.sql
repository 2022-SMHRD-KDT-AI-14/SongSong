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
constraint musiclist_diff_ck check(diff in('��','��','��'))
);	


select * from member;
select * from musiclist;


select path from musiclist where diff ='��' order by RAND()
select path from (select * from musiclist where diff = '��' order by dbms_random.value) where rownum <= 1;

select *from musiclist where singer ='CAMO'
select *from musiclist where singer ='ī��'


delete from musiclist where singer ='���座��'

update musiclist
set title ='MYRHYTHM'
path= 'C:/Users/smhrd/Desktop/MP3/music/���座�� - MYRHYTHM'
where singer ='���座��'


insert into musiclist
values('ž��','ȣ��������','C:/Users/smhrd/Desktop/MP3/music/ž�� - ȣ��������.mp3','��');
insert into musiclist
values('(����)���̵�','TOMBOY','C:/Users/smhrd/Desktop/MP3/music/���ھ��̵� - TOMBOY.mp3','��');
insert into musiclist
values('IVE(���̺�)','ELEVEN','C:/Users/smhrd/Desktop/MP3/music/���̺� - ELEVEN.mp3','��');
insert into musiclist
values('�����̽�','RUN2U','C:/Users/smhrd/Desktop/MP3/music/�����̾� - RUN2U.mp3','��');
insert into musiclist
values('�ǵ�������','����̺���������ϰھ�λ���ϴ°���','C:/Users/smhrd/Desktop/MP3/music/�ǵ������� - ����̺���������ϰھ�λ���ϴ°���.mp3','��');
insert into musiclist
values('�ܳ���','�����ϴ¿��ε�������','C:/Users/smhrd/Desktop/MP3/music/�ܳ��� - �����ϴ¿��ε�������.mp3','��');
insert into musiclist
values('��������','����ص��ɱ��','C:/Users/smhrd/Desktop/MP3/music/�������� - ����ص��ɱ��.mp3','��');
insert into musiclist
values('��ź�ҳ��','MAGICSHOP','C:/Users/smhrd/Desktop/MP3/music/��ź�ҳ�� - MAGICSHOP.mp3','��');
insert into musiclist
values('���̽Ľ�','�ູ�ߴ������̾���','C:/Users/smhrd/Desktop/MP3/music/���̽Ľ� - �ູ�ߴ������̾���.mp3','��');
insert into musiclist
values('CAMO','CAMO - LIFEISWET','C:/Users/smhrd/Desktop/MP3/music/ī�� - LIFEISWET.mp3','��');
insert into musiclist
values('���','�����������ܿ�','C:/Users/smhrd/Desktop/MP3/music/��� - �����������ܿ�.mp3','��');
insert into musiclist
values('���座��','FEELMYRHYTHM','C:/Users/smhrd/Desktop/MP3/music/���座�� - MYRHYTHM.mp3','��');
insert into musiclist
values('��θ���','���߰���','C:/Users/smhrd/Desktop/MP3/music/��θ��� - ���߰���.mp3','��');
insert into musiclist
values('�̹���','��ȣ��','C:/Users/smhrd/Desktop/MP3/music/�̹��� - ��ȣ��.mp3','��');
insert into musiclist
values('������','���','C:/Users/smhrd/Desktop/MP3/music/������ - ���.mp3','��');
insert into musiclist
values('����','THATTHAT','C:/Users/smhrd/Desktop/MP3/music/���� - THATTHAT.mp3','��');
insert into musiclist
values('�ӿ���','������õ�����','C:/Users/smhrd/Desktop/MP3/music/�ӿ��� - ������õ�����.mp3','��');
insert into musiclist
values('���ڵ���','ȸ����','C:/Users/smhrd/Desktop/MP3/music/���ڵ��� - ȸ����.mp3','��');
insert into musiclist
values('��ź�ҳ��','BUTTER','C:/Users/smhrd/Desktop/MP3/music/��ź�ҳ�� - BUTTER.mp3','��');
insert into musiclist
values('��ź�ҳ��','DYNAMITE','C:/Users/smhrd/Desktop/MP3/music/��ź�ҳ�� - DYNAMITE.mp3','��');
insert into musiclist
values('��ź�ҳ��','FIRE','C:/Users/smhrd/Desktop/MP3/music/��ź�ҳ�� - FIRE.mp3','��');
insert into musiclist
values('����ģ��','��','C:/Users/smhrd/Desktop/MP3/music/����ģ�� - ��.mp3','��');
insert into musiclist
values('Ʈ���̽�','TT','C:/Users/smhrd/Desktop/MP3/music/Ʈ���̽� - TT.mp3','��');
insert into musiclist
values('�����ִϾ�','SORRYSORRY','C:/Users/smhrd/Desktop/MP3/music/�����ִϾ� - SORRYSORRY.mp3','��');
insert into musiclist
values('���̴�','������','C:/Users/smhrd/Desktop/MP3/music/���̴� - ������.mp3','��');
insert into musiclist
values('���̴�','�����','C:/Users/smhrd/Desktop/MP3/music/���̴� - �����.mp3','��');
insert into musiclist
values('2PM','HEARTBEAT','C:/Users/smhrd/Desktop/MP3/music/2PM - HEARTBEAT.mp3','��');
insert into musiclist
values('�����ɽ�','TELLME','C:/Users/smhrd/Desktop/MP3/music/�����ɽ� - TELLME.mp3','��');
insert into musiclist
values('�����ɽ�','NOBODY','C:/Users/smhrd/Desktop/MP3/music/�����ɽ� - NOBODY.mp3','��');
insert into musiclist
values('�ٺ�ġ','8282','C:/Users/smhrd/Desktop/MP3/music/�ٺ�ġ - 8282.mp3','��');
insert into musiclist
values('ī��','�̽���','C:/Users/smhrd/Desktop/MP3/music/ī�� - MISTER.mp3','��');
insert into musiclist
values('������','������','C:/Users/smhrd/Desktop/MP3/music/������ - ������.mp3','��');
insert into musiclist
values('����','������','C:/Users/smhrd/Desktop/MP3/music/���� - ������.mp3','��');
insert into musiclist
values('�ҳ�ô�','GEE','C:/Users/smhrd/Desktop/MP3/music/�ҳ�ô� - GEE.mp3','��');
insert into musiclist
values('�ҳ�ô�','�ҿ������غ�','C:/Users/smhrd/Desktop/MP3/music/�ҳ�ô� - �ҿ������غ�.mp3','��');
insert into musiclist
values('��','��','C:/Users/smhrd/Desktop/MP3/music/�� - ��.mp3','��');
insert into musiclist
values('û��','����12��','C:/Users/smhrd/Desktop/MP3/music/û�� - ����12��.mp3','��');
insert into musiclist
values('SS501','URMAN','C:/Users/smhrd/Desktop/MP3/music/SS501 - URMAN.mp3','��');
insert into musiclist
values('�Ź�','YOUAREMYEVERYTHING','C:/Users/smhrd/Desktop/MP3/music/�Ź� - YOUAREMYEVERYTHING.mp3','��');
insert into musiclist
values('�帲����','DREAMHIGH','C:/Users/smhrd/Desktop/MP3/music/�帲���� - DREAMHIGH.mp3','��');
insert into musiclist
values('��','MYDESTINY','C:/Users/smhrd/Desktop/MP3/music/�� - MYDESTINY.mp3','��');
insert into musiclist
values('����Ŀ����Ŀ','���ɿ���','C:/Users/smhrd/Desktop/MP3/music/����Ŀ����Ŀ - ���ɿ���.mp3','��');
insert into musiclist
values('������','�Ѹ�����ó��','C:/Users/smhrd/Desktop/MP3/music/������ - �Ѹ�����ó��.mp3','��');
insert into musiclist
values('�극�̺�ɽ�','�Ѹ�','C:/Users/smhrd/Desktop/MP3/music/�극�̺�ɽ� - �Ѹ�.mp3','��');
insert into musiclist
values('���','COUNTINGSTARS','C:/Users/smhrd/Desktop/MP3/music/��� - COUNTINGSTARS.mp3','��');
insert into musiclist
values('���','��Ÿ��ƽ���̺�','C:/Users/smhrd/Desktop/MP3/music/��� - ��Ÿ��ƽ���̺�.mp3','��');
insert into musiclist
values('���̸յ��̴�','SIMONDOMINIC','C:/Users/smhrd/Desktop/MP3/music/���̸յ��̴� - SIMONDOMINIC.mp3','��');
insert into musiclist
values('����','������Ÿ��','C:/Users/smhrd/Desktop/MP3/music/���� - ������Ÿ��.mp3','��');
insert into musiclist
values('��������','�����̾�','C:/Users/smhrd/Desktop/MP3/music/�������� - �����̾�.mp3','��');
insert into musiclist
values('����ģ��','�ð����޷���','C:/Users/smhrd/Desktop/MP3/music/����ģ�� - �ð����޷���.mp3','��');
insert into musiclist
values('������ļ���','��Ż����','C:/Users/smhrd/Desktop/MP3/music/������ļ��� - ��Ż����.mp3','��');
insert into musiclist
values('����','�ƹ��뷡','C:/Users/smhrd/Desktop/MP3/music/���� - �ƹ��뷡.mp3','��');
insert into musiclist
values('�¿�','���','C:/Users/smhrd/Desktop/MP3/music/�¿� - ���.mp3','��');
insert into musiclist
values('���ִϿ�','���������߳���','C:/Users/smhrd/Desktop/MP3/music/���ִϿ� - ���������߳���.mp3','��');
insert into musiclist
values('Ƽ�ƽ�','�Ķ���̽�','C:/Users/smhrd/Desktop/MP3/music/Ƽ�ƽ� - �Ķ���̽�.mp3','��');
insert into musiclist
values('Ƽ�ƶ�','�Ѹ�����','C:/Users/smhrd/Desktop/MP3/music/Ƽ�ƶ� - �Ѹ�����.mp3','��');
insert into musiclist
values('�ּ�','��ȥ���������߾�','C:/Users/smhrd/Desktop/MP3/music/�ּ� - ��ȥ���������߾�.mp3','��');
insert into musiclist
values('����','������Ÿ��','C:/Users/smhrd/Desktop/MP3/music/���� - ������Ÿ��.mp3','��');
insert into musiclist
values('�迬��','�Ƹ���Ƽ','C:/Users/smhrd/Desktop/MP3/music/�迬�� - �Ƹ���Ƽ.mp3','��');
insert into musiclist
values('����','OHAYOMYNIGHTOHAYOMYNIGHT','C:/Users/smhrd/Desktop/MP3/music/���� - OHAYOMYNIGHTOHAYOMYNIGHT.mp3','��');
insert into musiclist
values('��ȿ��','���ǲ�','C:/Users/smhrd/Desktop/MP3/music/��ȿ�� - ���ǲ�.mp3','��');
insert into musiclist
values('�鿹��','SQUARE','C:/Users/smhrd/Desktop/MP3/music/�鿹�� - SQUARE.mp3','��');
insert into musiclist
values('����','�����Էζ����¿���','C:/Users/smhrd/Desktop/MP3/music/���� - �����Էζ����¿���.mp3','��');
insert into musiclist
values('�����������','���ǻ���⿡��','C:/Users/smhrd/Desktop/MP3/music/����������� - ���ǻ���⿡��.mp3','��');
insert into musiclist
values('������','����','C:/Users/smhrd/Desktop/MP3/music/������ - ����.mp3','��');
insert into musiclist
values('�ҳ��ž','����������','C:/Users/smhrd/Desktop/MP3/music/�ҳ��ž - ����������.mp3','��');
insert into musiclist
values('���̺�','LOVEDIVE','C:/Users/smhrd/Desktop/MP3/music/���̺� - LOVEDIVE.mp3','��');
insert into musiclist
values('������','CELEBRITY','C:/Users/smhrd/Desktop/MP3/music/������ - CELEBRITY.mp3','��');
insert into musiclist
values('���ϸ�','ù��ó���ʿ��԰��ڴ�','C:/Users/smhrd/Desktop/MP3/music/���ϸ� - ù��ó���ʿ��԰��ڴ�.mp3','��');
insert into musiclist
values('����','�ߵ�','C:/Users/smhrd/Desktop/MP3/music/���� - �ߵ�.mp3','��');
insert into musiclist
values('���ʿ�','ENERGETIC','C:/Users/smhrd/Desktop/MP3/music/���ʿ� - ENERGETIC.mp3','��');
insert into musiclist
values('������','����','C:/Users/smhrd/Desktop/MP3/music/������ - ����.mp3','��');
insert into musiclist
values('��ũ������','������','C:/Users/smhrd/Desktop/MP3/music/��ũ������ - ������.mp3','��');
insert into musiclist
values('���̵�','����ϰԵ��پ˾Ҿ�','C:/Users/smhrd/Desktop/MP3/music/���̵� - ����ϰԵ��پ˾Ҿ�.mp3','��');
insert into musiclist
values('�¾�','������','C:/Users/smhrd/Desktop/MP3/music/�¾� - ������.mp3','��');
insert into musiclist
values('�¿�','WHY','C:/Users/smhrd/Desktop/MP3/music/�¿� - WHY.mp3','��');
insert into musiclist
values('��Ŵ','��糯������','C:/Users/smhrd/Desktop/MP3/music/��Ŵ - ��糯������.mp3','��');
insert into musiclist
values('���̶���Ʈ','����Ǫ�������ƿ�','C:/Users/smhrd/Desktop/MP3/music/���̶���Ʈ - ����Ǫ�������ƿ�.mp3','��');
insert into musiclist
values('PL','ONALR','C:/Users/smhrd/Desktop/MP3/music/PL - ONALR.mp3','��');
insert into musiclist
values('�ٺ�ġ','�ʿ��Ը��ߴ�������������','C:/Users/smhrd/Desktop/MP3/music/�ٺ�ġ - �ʿ��Ը��ߴ�������������.mp3','��');
insert into musiclist
values('�̶���','ACHOO','C:/Users/smhrd/Desktop/MP3/music/�̶��� - ACHOO.mp3','��');
insert into musiclist
values('�����','ALLIWANNADO','C:/Users/smhrd/Desktop/MP3/music/����� - ALLIWANNADO.mp3','��');
insert into musiclist
values('��ȿ��','�����Ǹձ״뿡��','C:/Users/smhrd/Desktop/MP3/music/��ȿ�� - �����Ǹձ״뿡��.mp3','��');
insert into musiclist
values('����Ŀ����Ŀ','���','C:/Users/smhrd/Desktop/MP3/music/����Ŀ����Ŀ - ���.mp3','��');
insert into musiclist
values('����','�������ϸ�','C:/Users/smhrd/Desktop/MP3/music/���� - �������ϸ�.mp3','��');
insert into musiclist
values('������','UPGRADE2020','C:/Users/smhrd/Desktop/MP3/music/������ - UPGRADE2020.mp3','��');
insert into musiclist
values('���ĵ�����','����ϴ³ʿ���','C:/Users/smhrd/Desktop/MP3/music/���ĵ����� - ����ϴ³ʿ���.mp3','��');
insert into musiclist
values('�����','����','C:/Users/smhrd/Desktop/MP3/music/����� - ����.mp3','��');
insert into musiclist
values('����','��¥��������','C:/Users/smhrd/Desktop/MP3/music/���� - ��¥��������.mp3','��');
insert into musiclist
values('����','�ʵ��׳ɳ������ָ��','C:/Users/smhrd/Desktop/MP3/music/���� - �ʵ��׳ɳ������ָ��.mp3','��');
insert into musiclist
values('�̽±�','����̼���������','C:/Users/smhrd/Desktop/MP3/music/�̽±� - ����̼���������.mp3','��');
insert into musiclist
values('������','������������־��ٸ�','C:/Users/smhrd/Desktop/MP3/music/������ - ������������־��ٸ�.mp3','��');
insert into musiclist
values('�����','���̿����ʳ׿�','C:/Users/smhrd/Desktop/MP3/music/����� - ���̿����ʳ׿�.mp3','��');
insert into musiclist
values('��Ű','��������','C:/Users/smhrd/Desktop/MP3/music/��Ű - ��������.mp3','��');
insert into musiclist
values('��ȿ��','�����¾�Ի�����ϳ���','C:/Users/smhrd/Desktop/MP3/music/��ȿ�� - �����¾�Ի�����ϳ���.mp3','��');
insert into musiclist
values('�ֽ�ũ','�ƹ�������','C:/Users/smhrd/Desktop/MP3/music/�ֽ�ũ - �ƹ�������.mp3','��');
insert into musiclist
values('�ֽ�ũ','�ʸ�������','C:/Users/smhrd/Desktop/MP3/music/�ֽ�ũ - �ʸ�������.mp3','��');
insert into musiclist
values('þ','�����������츮�������','C:/Users/smhrd/Desktop/MP3/music/þ - �����������츮�������.mp3','��');
insert into musiclist
values('�¿�','���','C:/Users/smhrd/Desktop/MP3/music/�¿� - ���.mp3','��');