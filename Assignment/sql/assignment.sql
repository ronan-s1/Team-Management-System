DROP TABLE IF EXISTS players;
DROP TABLE IF EXISTS squads;
DROP TABLE IF EXISTS squad_players;
DELETE FROM players;
DELETE FROM squads;
DELETE FROM squad_players;
TRUNCATE TABLE squads;
TRUNCATE TABLE players;
TRUNCATE TABLE squad_players;


CREATE TABLE players (
	PLAYER_ID int(11) NOT NULL AUTO_INCREMENT,
	FIRST_NAME varchar(50) NOT NULL,
	LAST_NAME varchar(50) NOT NULL,
	DOB varchar(20) NOT NULL,
	CONTACT_NUMBER varchar(20) NOT NULL,
	EMAIL varchar(50) NOT NULL,
	PRIMARY KEY (PLAYER_ID)
);
  
CREATE TABLE squads (
	SQUAD_ID int(11) NOT NULL AUTO_INCREMENT,
	SQUAD_NAME varchar(50) NOT NULL,
	PRIMARY KEY (SQUAD_ID)
);
 
CREATE TABLE squad_players (
	PLAYER_ID int(11),
	SQUAD_ID int(11),
	FOREIGN KEY (PLAYER_ID) REFERENCES players(PLAYER_ID),
	FOREIGN KEY (SQUAD_ID) REFERENCES squads(SQUAD_ID)
);
 
 INSERT INTO squads VALUES (null, "The Slippery Slurpers");
 INSERT INTO squads VALUES (null, "The Bouncy Ballers");
 INSERT INTO squads VALUES (null, "The Musty Munchers");
 INSERT INTO squads VALUES (null, "The Slimey Snails");
 
 
 