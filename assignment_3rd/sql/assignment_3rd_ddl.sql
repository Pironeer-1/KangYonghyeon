CREATE TABLE `Board` (
                         `Key`	INTEGER	NOT NULL,
                         `title`	VARCHAR(50)	NULL,
                         `content`	VARCHAR(255)	NULL,
                         `createdAt`	DATETIME	NULL,
                         `updateAt`	DATETIME	NULL,
                         `member_id`	INTEGER	NOT NULL
);

CREATE TABLE `Member` (
                          `Key`	INTEGER	NOT NULL,
                          `name`	CHAR(255)	NULL,
                          `password`	CHAR(50)	NULL
);

ALTER TABLE `Board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
                                                           `Key`
    );

ALTER TABLE `Member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
                                                             `Key`
    );

