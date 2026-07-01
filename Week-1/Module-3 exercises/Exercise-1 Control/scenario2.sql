SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_balance_check IS
        SELECT CustomerID, Name, Balance FROM Customers;
BEGIN
    FOR rec IN cur_balance_check LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(rec.Name || ' promoted to VIP (Balance: $' ||
                rec.Balance || ')');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status evaluation finished.');
END;
/
