DROP TABLE IF EXISTS cafes;

CREATE TABLE cafes (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  place VARCHAR(40) NOT NULL,
  regularHoliday VARCHAR(50) NOT NULL,
  openingHour VARCHAR(50) NOT NULL,
  numberOfSeat int NOT NULL,
  birthplace VARCHAR(30) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO cafes (name, place, regularHoliday, openingHour, numberOfSeat, birthplace) VALUES ("Starbucks Reserve Roastery", "中目黒", "年中無休", "7時-22時", 300, "シアトル");
INSERT INTO cafes (name, place, regularHoliday, openingHour, numberOfSeat, birthplace) VALUES ("nadoya no katte", "代々木上原", "月、火、水、木", "9時-18時", 15, "代々木上原");
INSERT INTO cafes (name, place, regularHoliday, openingHour, numberOfSeat, birthplace) VALUES ("Streamer Coffee Company", "原宿", "年中無休","8時-20時", 56, "原宿");
INSERT INTO cafes (name, place, regularHoliday, openingHour, numberOfSeat, birthplace) VALUES ("ブルーボトルコーヒー清澄白河フラッグシップカフェ", "清澄白河", "年中無休", "8時-19時", 47, "カリフォルニア");
INSERT INTO cafes (name, place, regularHoliday, openingHour, numberOfSeat, birthplace) VALUES ("ARC", "蔵前", "年中無休", "平日10時-23時 休日8時半-23時", 52, "蔵前");
INSERT INTO cafes (name, place, regularHoliday, openingHour, numberOfSeat, birthplace) VALUES ("T.Y.HARBOR", "天王洲アイル", "年中無休", "11時半-22時", 350, "天王洲アイル");
INSERT INTO cafes (name, place, regularHoliday, openingHour, numberOfSeat, birthplace) VALUES ("No.13 Cafe", "新宿", "日", "11時-16時半", 30, "新宿");

