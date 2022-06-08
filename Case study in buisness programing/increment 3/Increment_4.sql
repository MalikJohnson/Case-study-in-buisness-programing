

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