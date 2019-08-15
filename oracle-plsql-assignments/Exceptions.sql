/*
Assignement1: Write a PL/SQL block to handle the exception named “DUP_VAL_ON_INDEX by inserting a duplicate row in the course table.
*/

DECLARE 
BEGIN 
   insert into Course values('C001', 100, 'Oracle PLSQL', 'Bla Bla..', 2000);
   EXCEPTION 
    WHEN DUP_VAL_ON_INDEX  THEN
       DBMS_OUTPUT.PUT_LINE('Duplicate Entry!');
END;

/*
Assignement2: Write a PL/SQL block to handle the exception named “VALUE_ERROR” by inserting the value for DeptName column of width greater than 21 into the department table.
*/

DECLARE 
BEGIN 
   insert into Department values(101, 'aaaaaaaaaaaaaaaaaaaaaaaa', 'SEZ1');
   EXCEPTION 
    WHEN VALUE_ERROR THEN
       DBMS_OUTPUT.PUT_LINE('Value is too long!');
END;

/*
Assignement3: Write a PL/SQL block to handle the exceptions which are not handled by using OTHERS and display a message.
*/
DECLARE 
BEGIN 
   insert into Department values(101, 'abc', 'SEZ1');
   EXCEPTION 
    WHEN others THEN
       DBMS_OUTPUT.PUT_LINE('Error!');
END;