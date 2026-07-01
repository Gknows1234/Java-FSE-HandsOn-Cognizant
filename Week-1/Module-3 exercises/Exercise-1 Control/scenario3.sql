SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_upcoming_due IS
        SELECT c.Name, l.LoanID, l.LoanAmount, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== Loans Due Within Next 30 Days ===');
    DBMS_OUTPUT.PUT_LINE('');

    FOR rec IN cur_upcoming_due LOOP
        DBMS_OUTPUT.PUT_LINE('Customer  : ' || rec.Name);
        DBMS_OUTPUT.PUT_LINE('Loan ID   : ' || rec.LoanID);
        DBMS_OUTPUT.PUT_LINE('Amount    : $' || rec.LoanAmount);
        DBMS_OUTPUT.PUT_LINE('Due Date  : ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('---');
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Reminder processing complete.');
END;
/
