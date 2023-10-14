drop table if exists posting;
drop table if exists users;
CREATE TABLE users (
    idx int NOT NULL AUTO_INCREMENT,
    id char(20) NOT NULL,
    password char(20)  NOT NULL,
    PRIMARY KEY (`idx`)
);

CREATE TABLE posting (
   idx int NOT NULL AUTO_INCREMENT,
   title char(20) NOT NULL,
   user_idx int NOT NULL,
   content char(255) NOT NULL,
   PRIMARY KEY (idx),
   KEY user_idx (user_idx),
   FOREIGN KEY (user_idx) REFERENCES users (idx)
);