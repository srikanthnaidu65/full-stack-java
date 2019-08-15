/*
Create a procedure that takes an argument(Description) and deletes the row from the table named “Course”.
*/

create or replace procedure proc_delete_course (descr IN VARCHAR2)
IS 
BEGIN 
   delete from Course where Description = descr;
END; 

/*
Write a function that will get the value from the user and insert rows into the class table without violating integrity constraints.
*/

create or replace FUNCTION insert_class (cid IN varchar2, cschdid IN varchar2, cbuild IN varchar2, croom IN varchar2, cdeptno IN number, cinstr_id IN varchar2, csem IN varchar2, cyear IN date)
return number
IS 
cnumber number;
BEGIN 
insert into Class values (cid, cschdid, cbuild, croom, cdeptno, cinstr_id, csem, cyear );
return cnumber; 
EXCEPTION
  WHEN OTHERS THEN 
    cnumber:=0;
return cnumber;    
END; 

declare 
result number;
begin
result:= insert_class('C1', 'S1', 'Block1', 'CSE', 100, 'I1','1','2-May-18');
IF result=0 THEN
DBMS_OUTPUT.PUT_LINE('Integrity violation occured');
END IF;
end;

/*
Write a procedure that will display the users to which the specified table is granted.
*/

create or replace procedure display_users()
IS 
BEGIN 
   select owner, table_name from all_tables where owner = 'TOPGEAR';
END; 

/*
Create a package that contains overloaded functions for:
a.	Adding five integers.
b.	Subtracting two integers.
c.	Multiplying three integers.
*/

create or replace package overexample AS
PROCEDURE calc(a number,b number);
PROCEDURE calc(a number,b number,c number,d number,e number);
PROCEDURE calc(a number,b number,c number);
 END overexample;

create or replace package BODY overexample AS
procedure calc(a number,b number) IS
BEGIN 
DBMS_OUTPUT.PUT_LINE(a-b);
END calc;
procedure calc(a number,b number,c number,d number,e number) IS
BEGIN 
DBMS_OUTPUT.PUT_LINE(a+b+c+d+e);
END calc;
procedure calc(a number,b number,c NUMBER) IS
BEGIN 
DBMS_OUTPUT.PUT_LINE(a*b*c);
END calc;
END overexample;
 
declare 
var1 number:=5;
var2 number:=6;
var3 number:=4;
var4 number:=9;
var5 number:=12;
begin
overexample.calc(var1,var2,var3);
overexample.calc(var1,var2);
overexample.calc(var1,var2,var3,var4,var5);
end;
