BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    AccountHolder VARCHAR2(100),
    AccountType VARCHAR2(50),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    FullName VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER
);

INSERT INTO Accounts VALUES (1001, 'Anita Desai', 'Savings', 25000);
INSERT INTO Accounts VALUES (1002, 'Rajesh Gupta', 'Current', 48000);
INSERT INTO Accounts VALUES (1003, 'Sunita Verma', 'Savings', 12000);
INSERT INTO Accounts VALUES (1004, 'Kiran Joshi', 'Savings', 60000);
INSERT INTO Accounts VALUES (1005, 'Manoj Tiwari', 'Current', 35000);

INSERT INTO Employees VALUES (201, 'Deepak Mishra', 'Engineering', 75000);
INSERT INTO Employees VALUES (202, 'Kavita Singh', 'Marketing', 55000);
INSERT INTO Employees VALUES (203, 'Rohit Shetty', 'Engineering', 82000);
INSERT INTO Employees VALUES (204, 'Neha Kapoor', 'HR', 48000);
INSERT INTO Employees VALUES (205, 'Amit Chauhan', 'Marketing', 62000);

COMMIT;
