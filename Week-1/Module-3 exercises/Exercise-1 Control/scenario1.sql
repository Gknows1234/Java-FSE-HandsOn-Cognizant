SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_all_customers IS
        SELECT CustomerID, Name, DOB FROM Customers;
    v_customer_age NUMBER;
BEGIN
    FOR rec IN cur_all_customers LOOP
        v_customer_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_customer_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1.0
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Discount applied for ' || rec.Name ||
                ' (Age: ' || v_customer_age || ')');
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Senior citizen discount processing complete.');
END;
/
