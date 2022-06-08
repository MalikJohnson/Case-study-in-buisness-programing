
CREATE SEQUENCE seq_userId
INCREMENT BY 1
START WITH 1
CACHE 10
NOCYCLE;

CREATE TABLE Mj_user (
    userId int NOT NULL,
    userName varchar(255),
    passWord varchar(255),
    firstName varchar(255),
    lastName varchar(255),
    budgetAmount NUMBER(10,2),
    incomeAmount NUMBER(10,2),
    savingsAmount NUMBER(10,2),
    numberOfBankAccounts int,
    bankAccountTotal NUMBER(10,2),
   CONSTRAINT PK_userId PRIMARY KEY (userId)
);

CREATE SEQUENCE seq_budgetId
INCREMENT BY 1
START WITH 1
CACHE 10
NOCYCLE;

CREATE TABLE Mj_budget (
    budgetId int NOT NULL,
    budgetType varchar(255),
    budgetName varchar(255),
    userId int,
    budgetAmount NUMBER(10,2),
    budgetTotal NUMBER(10,2) DEFAULT 0,
    overBudget varchar(255) DEFAULT 'FALSE',
    CONSTRAINT PK_budgetId PRIMARY KEY (budgetId),
    CONSTRAINT FK_userId FOREIGN KEY(userId) REFERENCES Mj_user(userId) ON DELETE CASCADE
);


CREATE SEQUENCE seq_itemId
INCREMENT BY 1
START WITH 1
CACHE 10
NOCYCLE;

CREATE TABLE Mj_item (
    itemId int NOT NULL,
    itemName varchar(255),
    itemType varchar(255),
    itemPrice NUMBER(10,2),
    itemQuantity int,
    purchaseDate date,
    budgetId int,
    CONSTRAINT PK_itemId PRIMARY KEY(itemId),
    CONSTRAINT FK_budgetId FOREIGN KEY(budgetId) REFERENCES Mj_budget(budgetId) ON DELETE CASCADE
);



CREATE SEQUENCE seq_displayId
INCREMENT BY 1
START WITH 1
CACHE 10
NOCYCLE;

CREATE TABLE Mj_display (
    displayId int NOT NULL,
    displayName varchar(255),
    budgetId int,
    displayLayout varchar(255),
    graphType varchar(255),
    CONSTRAINT PK_displayId PRIMARY KEY(displayId),
    CONSTRAINT FK_budgetIdDisplay FOREIGN KEY(budgetId) REFERENCES Mj_budget(budgetId) ON DELETE CASCADE
);


CREATE SEQUENCE seq_reminderId
INCREMENT BY 1
START WITH 1
CACHE 10
NOCYCLE;

CREATE TABLE Mj_reminder (
    reminderId int NOT NULL,
    reminderName varchar(255),
    reminderType varchar(255),
    dateActivated date,
    budgetId int,
    reminderPercent NUMBER(10,2),
    CONSTRAINT PK_reminderId PRIMARY KEY(reminderId),
    CONSTRAINT FK_budgetIdReminder FOREIGN KEY(budgetId) REFERENCES Mj_budget(budgetId) ON DELETE CASCADE
);