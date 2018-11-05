CREATE TABLE UserInfo
(
    UserId NUMBER PRIMARY KEY,
    FirstName VARCHAR(40) NOT NULL,
    LastName VARCHAR(40) NOT NULL,
    Username VARCHAR2(40) NOT NULL UNIQUE,
    Password VARCHAR(40) NOT NULL
);

CREATE TABLE AccountType
(
    TypeId NUMBER PRIMARY KEY,
    Type VARCHAR(10) NOT NULL
);

CREATE TABLE AccountInfo
(
    AccountId NUMBER PRIMARY KEY,
    TypeId NUMBER NOT NULL,
    Owner VARCHAR(40) NOT NULL,
    Balance NUMBER NOT NULL,
    CONSTRAINT FK_AccountInfoUserInfo FOREIGN KEY (Owner) REFERENCES UserInfo(Username),
    CONSTRAINT FK_AccountInfoAccountType FOREIGN KEY (TypeId) REFERENCES AccountType(TypeId)
);

drop table UserInfo;