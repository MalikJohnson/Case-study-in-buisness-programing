
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