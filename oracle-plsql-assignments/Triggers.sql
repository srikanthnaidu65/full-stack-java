/*
Assignment1: Write a database trigger before insert for each row on the course table not allowing transactions on Sundays and Saturdays.
*/

create or replace trigger t_course
before insert on Course
declare 
d varchar2(20);
begin
select TO_CHAR(sysdate, 'day') into d from dual;
      IF (d = 'Saturday 'OR d = 'Sunday') then
      raise_application_error(-20000, 'Its Weekend!');
      END IF;
end;

/*
Assignment2: Write a database trigger after update for each row giving the date and the day on which the update is performed on the class table.
*/

create or replace trigger c_class
after update on Class
for each row
declare
var1 varchar2(20);
var2 varchar2(20);
begin
select TO_CHAR(sysdate, 'day'),sysdate into var1, var2 from dual;
DBMS_OUTPUT.put_line(var1 || ' ' || var2);
end;

/*
Assignment3: Write a database trigger before delete for each row not allowing deletion and giving message on the department table.
*/

create or replace trigger c_dept
before delete on Department
for each row
declare
begin
raise_application_error(-20000, 'delete operation not allowed');
end;

/*
Assignment4: Write a database trigger before insert/delete/update for each row not allowing any of these operations on the table student on Monday, Wednesday and Sunday.
*/
create or replace trigger c_stud
before insert or update or delete on Student
for each row
declare
var1 varchar2(10);
begin
select TO_CHAR(sysdate, 'day') into var1 from dual;
IF var1 ='Monday ' or var1='Wednesday ' or var1='Sunday ' THEN
raise_application_error(-20000, 'outside working hours');
END IF;
end;

/*
Assignment5: Write a database trigger before insert / update for each row not allowing any of these operations on the table Instructor between 6 PM to 10 AM.
*/
create or replace trigger c_inst
before insert or update  on Instructor
for each row
declare
var1 number;
begin
select TO_CHAR(sysdate,'HH24') into var1 from dual;
IF var1 >18 and var1 <10 THEN
raise_application_error(-20000, 'outside working hours');
END IF;
end;
