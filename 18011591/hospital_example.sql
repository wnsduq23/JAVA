DROP DATABASE IF EXISTS hospital;
DROP USER IF EXISTS hospital@localhost;

create user hospital@localhost identified WITH mysql_native_password  by 'hospital';
create database hospital;
grant all privileges on hospital.* to hospital@localhost with grant option;
commit;

USE hospital;

CREATE TABLE Doctors (
  doc_id INTEGER NOT NULL,
  major_treat VARCHAR(25) NOT NULL,
  doc_name VARCHAR(20) NOT NULL,
  doc_gen VARCHAR(1) NOT NULL,
  doc_phone VARCHAR(15) NULL,
  doc_email VARCHAR(50) UNIQUE,
  doc_position VARCHAR(20) NOT NULL
);

ALTER TABLE Doctors
  ADD CONSTRAINT doc_id_pk PRIMARY KEY (doc_id);

CREATE TABLE Nurses (
  nur_id INTEGER NOT NULL,
  major_job VARCHAR(25) NOT NULL,
  nur_name VARCHAR(20) NOT NULL,
  nur_gen char(1) NOT NULL,
  nur_phone VARCHAR(15) NULL,
  nur_email VARCHAR(50) UNIQUE,
  nur_position VARCHAR(20) NOT NULL
);

ALTER TABLE Nurses
  ADD CONSTRAINT nur_id_pk PRIMARY KEY (nur_id);

CREATE TABLE Patients (
  pat_id INTEGER NOT NULL,
  nur_id INTEGER NOT NULL,
  doc_id INTEGER NOT NULL,
  pat_name VARCHAR(20) NOT NULL,
  pat_gen VARCHAR(1) NOT NULL,
  pat_jumin VARCHAR(14) NOT NULL,
  pat_addr VARCHAR(100) NOT NULL,
  pat_phone VARCHAR(15) NULL,
  pat_email VARCHAR(50) UNIQUE,
  pat_job VARCHAR(20) NOT NULL
);

ALTER TABLE Patients
  ADD CONSTRAINT pat_id_pk PRIMARY KEY (pat_id);

ALTER TABLE Patients
  ADD (CONSTRAINT R_2 FOREIGN KEY (doc_id) REFERENCES Doctors (doc_id));

ALTER TABLE Patients
  ADD (CONSTRAINT R_3 FOREIGN KEY (nur_id) REFERENCES Nurses (nur_id));

CREATE TABLE Treatments (
  treat_id INTEGER NOT NULL,
  pat_id INTEGER NOT NULL,
  doc_id INTEGER NOT NULL,
  treat_contents VARCHAR(1000) NOT NULL,
  treat_date DATE NOT NULL
);

ALTER TABLE Treatments
  ADD CONSTRAINT treat_pat_doc_id_pk PRIMARY KEY (treat_id, pat_id, doc_id);

ALTER TABLE Treatments
  ADD (CONSTRAINT R_5 FOREIGN KEY (pat_id) REFERENCES Patients (pat_id));

ALTER TABLE Treatments
  ADD (CONSTRAINT R_6 FOREIGN KEY (doc_id) REFERENCES Doctors (doc_id));

CREATE TABLE Charts (
  chart_id VARCHAR(20) NOT NULL,
  treat_id INTEGER NOT NULL,
  doc_id INTEGER NOT NULL,
  pat_id INTEGER NOT NULL,
  nur_id INTEGER NOT NULL,
  chart_contents VARCHAR(1000) NOT NULL
);

ALTER TABLE Charts
  ADD CONSTRAINT chart_treat_doc_pat_id_pk PRIMARY KEY (chart_id, treat_id, doc_id, pat_id);

ALTER TABLE Charts
  ADD (CONSTRAINT R_4 FOREIGN KEY (nur_id) REFERENCES Nurses (nur_id));

ALTER TABLE Charts
  ADD (CONSTRAINT R_7 FOREIGN KEY (treat_id, pat_id, doc_id) REFERENCES Treatments (treat_id, pat_id, doc_id));

INSERT INTO Doctors VALUES(980312, '소아과', '이태정', 'M', '010-333-1340', 'ltj@hanbit.com', '과장');
INSERT INTO Doctors VALUES(000601, '내과', '안성기', 'M', '011-222-0987', 'ask@hanbit.com', '과장');
INSERT INTO Doctors VALUES(001208, '외과', '김민종', 'M', '010-333-8743', 'kmj@hanbit.com', '과장');
INSERT INTO Doctors VALUES(020403, '피부과', '이태서', 'M', '019-777-3764', 'lts@hanbit.com', '과장');
INSERT INTO Doctors VALUES(050900, '소아과', '김연아', 'F', '010-555-3746', 'kya@hanbit.com', '전문의');
INSERT INTO Doctors VALUES(050101, '내과', '차태현', 'M', '011-222-7643', 'cth@hanbit.com', '전문의');
INSERT INTO Doctors VALUES(062019, '소아과', '전지현', 'F', '010-999-1265', 'jjh@hanbit.com', '전문의');
INSERT INTO Doctors VALUES(070576, '피부과', '홍길동', 'M', '016-333-7263', 'hgd@hanbit.com', '전문의');
INSERT INTO Doctors VALUES(080543, '방사선과', '유재석', 'M', '010-222-1263', 'yjs@hanbit.com', '과장');
INSERT INTO Doctors VALUES(091001, '외과', '김병만', 'M', '010-555-3542', 'kbm@hanbit.com', '전문의');

INSERT INTO Nurses VALUES(050302, '소아과', '김은영', 'F', '010-555-8751', 'key@hanbit.com', '수간호사');
INSERT INTO Nurses VALUES(050021, '내과', '윤성애', 'F', '016-333-8745', 'ysa@hanbit.com', '수간호사');
INSERT INTO Nurses VALUES(040089, '피부과', '신지원', 'M', '010-666-7646', 'sjw@hanbit.com', '주임');
INSERT INTO Nurses VALUES(070605, '방사선과', '유정화', 'F', '010-333-4588', 'yjh@hanbit.com', '주임');
INSERT INTO Nurses VALUES(070804, '내과', '라하나', 'F', '010-222-1340', 'nhn@hanbit.com', '주임');
INSERT INTO Nurses VALUES(071018, '소아과', '김화경', 'F', '019-888-4116', 'khk@hanbit.com', '주임');
INSERT INTO Nurses VALUES(100356, '소아과', '이선용', 'M', '010-777-1234', 'lsy@hanbit.com', '간호사');
INSERT INTO Nurses VALUES(104145, '외과', '김현', 'M', '010-999-8520', 'kh@hanbit.com', '간호사');
INSERT INTO Nurses VALUES(120309, '피부과', '박성완', 'M', '010-777-4996', 'psw@hanbit.com', '간호사');
INSERT INTO Nurses VALUES(130211, '외과', '이서연', 'F', '010-222-3214', 'lsy2@hanbit.com', '간호사');

INSERT INTO Patients VALUES(2345, 050302, 980312, '안상건', 'M', 232345, '서울', '010-555-7845', 'ask@ab.com', '회사원');
INSERT INTO Patients VALUES(3545, 040089, 020403, '김성룡', 'M', 543545, '서울', '010-333-7812', 'ksn@bb.com', '자영업');
INSERT INTO Patients VALUES(3424, 070605, 080543, '이종진', 'M', 433424, '부산', '010-888-4859', 'ljj@ab.com', '회사원');
INSERT INTO Patients VALUES(7675, 100356, 050900, '최광석', 'M', 677675, '당진', '010-222-4847', 'cks@cc.com', '회사원');
INSERT INTO Patients VALUES(4533, 070804, 000601, '정한경', 'M', 744533, '강릉', '010-777-9630', 'jhk@ab.com', '교수');
INSERT INTO Patients VALUES(5546, 120309, 070576, '유원현', 'M', 765546, '대구', '016-777-0214', 'ywh@cc.com', '자영업');
INSERT INTO Patients VALUES(4543, 070804, 050101, '최재정', 'M', 454543, '부산', '010-555-4187', 'cjj@bb.com', '회사원');
INSERT INTO Patients VALUES(9768, 130211, 091001, '이진희', 'F', 119768, '서울', '010-888-3675', 'ljh@ab.com', '교수');
INSERT INTO Patients VALUES(4234, 130211, 091001, '오나미', 'F', 234234, '속초', '010-999-6541', 'onm@cc.com', '학생');
INSERT INTO Patients VALUES(7643, 071018, 062019, '송석묵', 'M', 987643, '서울', '010-222-5874', 'ssm@bb.com', '학생');

INSERT INTO Treatments VALUES(130516023, 2345, 980312, '감기, 몸살', STR_TO_DATE('2013-05-16','%Y-%m-%d'));
INSERT INTO Treatments VALUES(130628100, 3545, 020403, '피부 트러블 치료', STR_TO_DATE('2013-06-28','%Y-%m-%d'));
INSERT INTO Treatments VALUES(131205056, 3424, 080543, '목 디스크로 MRI 촬영', STR_TO_DATE('2013-12-05','%Y-%m-%d'));
INSERT INTO Treatments VALUES(131218024, 7675, 050900, '중이염', STR_TO_DATE('2013-12-18','%Y-%m-%d'));
INSERT INTO Treatments VALUES(131224012, 4533, 000601, '장염', STR_TO_DATE('2013-12-24','%Y-%m-%d'));
INSERT INTO Treatments VALUES(140103001, 5546, 070576, '여드름 치료', STR_TO_DATE('2014-01-03','%Y-%m-%d'));
INSERT INTO Treatments VALUES(140109026, 4543, 050101, '위염', STR_TO_DATE('2014-01-09','%Y-%m-%d'));
INSERT INTO Treatments VALUES(140226102, 9768, 091001, '화상치료', STR_TO_DATE('2014-02-26','%Y-%m-%d'));
INSERT INTO Treatments VALUES(140303003, 4234, 091001, '교통사고 외상치료', STR_TO_DATE('2014-03-03','%Y-%m-%d'));
INSERT INTO Treatments VALUES(140308087, 7643, 062019, '장염', STR_TO_DATE('2014-03-08','%Y-%m-%d'));

INSERT INTO Charts VALUES('PD13572410', 130516023, 980312, 2345, 050302, '편도선, 감기약 처방');
INSERT INTO Charts VALUES('DM11389132', 130628100, 020403, 3545, 040089, '피부약 처방');
INSERT INTO Charts VALUES('RD10023842', 131205056, 080543, 3424, 070605, '목 디스크 의심, 추가 검사 필요');
INSERT INTO Charts VALUES('PD13581241', 131218024, 050900, 7675, 100356, '세반고리관 추가 검사 필요');
INSERT INTO Charts VALUES('IM12557901', 131224012, 000601, 4533, 070804, '위장약 처방');
INSERT INTO Charts VALUES('DM11400021', 140103001, 070576, 5546, 120309, '여드름 치료제 처방');
INSERT INTO Charts VALUES('IM12708224', 140109026, 050101, 4543, 070804, '위염 심각, 추가 검사 후 수술 권함');
INSERT INTO Charts VALUES('GS17223681', 140226102, 091001, 9768, 130211, '화상약 처방 및 물리치료');
INSERT INTO Charts VALUES('GS17264430', 140303003, 091001, 4234, 130211, '추가 성형수술 필요함');
INSERT INTO Charts VALUES('PD13664611', 140308087, 062019, 7643, 071018, '장염약 처방');