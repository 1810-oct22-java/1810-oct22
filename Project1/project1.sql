CREATE TABLE reimbursement (
    id            NUMBER PRIMARY KEY,
    amount        NUMBER NOT NULL,
    submitted     TIMESTAMP NOT NULL,
    resolved      TIMESTAMP,
    description   VARCHAR2(250),
    receipt       BLOB,
    author        NUMBER NOT NULL,
    resolver      NUMBER,
    status_id     NUMBER NOT NULL,
    type_id       NUMBER NOT NULL,
    CONSTRAINT fk FOREIGN KEY ( author )
        REFERENCES users ( users_id ),
    FOREIGN KEY ( resolver )
        REFERENCES users ( users_id ),
    FOREIGN KEY ( status_id )
        REFERENCES reimbursement_status ( status_id ),
    FOREIGN KEY ( type_id )
        REFERENCES reimbursement_type ( type_id )
);

CREATE TABLE users (
    users_id     NUMBER PRIMARY KEY,
    username     VARCHAR2(50) UNIQUE NOT NULL,
    password     VARCHAR2(50) NOT NULL,
    first_name   VARCHAR2(100) NOT NULL,
    last_name    VARCHAR2(100) NOT NULL,
    email        VARCHAR2(150) UNIQUE NOT NULL,
    role_id      NUMBER NOT NULL,
    CONSTRAINT fk2 FOREIGN KEY ( role_id )
        REFERENCES user_roles ( user_role_id )
);

CREATE TABLE reimbursement_status (
    status_id   NUMBER PRIMARY KEY,
    status      VARCHAR2(10) NOT NULL
);

CREATE TABLE reimbursement_type (
    type_id   NUMBER PRIMARY KEY,
    type      VARCHAR2(10) NOT NULL
);

CREATE TABLE user_roles (
    user_role_id   NUMBER PRIMARY KEY,
    user_role      VARCHAR2(10) NOT NULL
);

DROP TABLE users;