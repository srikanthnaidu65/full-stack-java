/*
Assignement1:	Write a PL/SQL block to insert the student details into the Student table until the user wishes to stop.
*/

WHENEVER SQLERROR exit;
set serveroutput on;

accept v_student_id 	prompt 'Enter StudentId';
accept v_first_name 	prompt 'Enter FirstName';
accept v_last_name 		prompt 'Enter LastName';
accept v_dob date 		prompt 'Enter DOB(dd-mmm-yyyy)';
accept v_address 		prompt 'Enter Address';
accept v_city 			prompt 'Enter City';
accept v_state 			prompt 'Enter State';
accept v_zipcode 		prompt 'Enter Zipcode';
accept v_telephone 		prompt 'Enter Telephone';
accept v_fax 			prompt 'Enter Fax';
accept v_email 			prompt 'Enter Email';

insert into Student
values('&v_student_id','&v_first_name','&v_last_name','&v_dob',
        '&v_address','&v_city','&v_state','&v_zipcode','&v_telephone',
        '&v_fax','&v_email');

accept x_value  number prompt 'Enter 1 to continue 0 to Stop';

begin
  if(&x_value = 0) then
  commit;
  DBMS_OUTPUT.PUT_LINE('Success');
  RAISE_APPLICATION_ERROR(-20000, 'Done'); 
  end if;								   
end;

/*
Assignement2: Write a PL/SQL block to display the numbers from 1 to 50 in words.
*/
	
set serveroutput on;

declare
  num number(2);
begin
  for num in 1..50
  loop
	DBMS_OUTPUT.PUT_LINE(num || ' :' || to_char(to_date(num,'j'),'jsp'));
  end loop;
end;

/*
Assignement3: Write a PL/SQL block to display the name of the employees whose salary is > 3000.
*/

set serveroutput on;
declare
cursor emp_cur is
select ename from employee where salary > 3000;
emp_rec emp_cur%rowtype;
begin
open emp_cur;
loop
fetch emp_cur into emp_rec;
 exit when emp_cur%notfound;  
 DBMS_OUTPUT.PUT_LINE('Employee Name: '|| emp_rec.ename);
end loop;
close emp_cur;
end;

/*
Assignement4: Write a PL/SQL block to accept the Department Number from the user, check for the existence in Department table, if exist display the department details for the specified department number else display appropriate error message.
*/

set serveroutput on;
set define '&';
declare
v_DeptNo Integer :=&v_deptno;
v_DeptName varchar2(21);
v_DeptLocation varchar2(13);

begin
select DeptNo, DeptName, DeptLocation 
into v_DeptNo, v_DeptName, v_DeptLocation 
from department 
where DeptNo = v_DeptNo;

DBMS_OUTPUT.PUT_LINE(v_DeptNo ||' '|| v_DeptName||' '|| v_DeptLocation);

exception
 when NO_DATA_FOUND then
 DBMS_OUTPUT.PUT_LINE('No data available for the given DeptId in department table.');
end;

/*
Assignement5: Write a PL/SQL block to accept the CourseId from the user, check for the existence in Course table, if exist remove the records if the user wishes to delete else display appropriate error message.
*/

set serveroutput on;
declare
CourseId varchar(5);
Begin
CourseId:='&CourseId';
delete from Course where CourseId = CourseId;

IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('No such CourseId.'); 
END IF;
END;

/*
Assignement6: Write a PL/SQL block to display ClassId, Grade and GradeAssigned details for the specified StudentId
*/

set serveroutput on;
declare
StudentId varchar(20);
var1 varchar(20);
var2 varchar(20);
var3 varchar(20);
Begin
StudentId:= '&StudentId';
select classID, Grade, GradeAssigned 
into var1, var2, var3 
from StudentSchedule 
where StudentId = StudentId;
DBMS_OUTPUT.PUT_LINE('ClassID: '|| var1 || 'Grade:' || var2 || 'Grade Assigned:' || var3);
END;

/*
Assignement7: Write a PL/SQL block to increase the salary of the employee by 15%, if their salary is > 15000
*/

set serveroutput on;
Begin
update Employee 
   set Salary = case 
                  when Salary  > 15000 then Salary * 1.15
                end;
END;

/*
Assignement8: Write a PL/SQL block to insert the records recursively into the Instructor table until the user wishes to terminate. Provided if the record count is > 20.
*/

WHENEVER SQLERROR exit;
set serveroutput on;

accept v_InstructorId 	prompt 'Enter InstructorId';
accept v_DeptNo 		prompt 'Enter DeptNo';
accept v_FirstName 		prompt 'Enter FirstName';
accept v_LastName 		prompt 'Enter LastName';
accept v_Telephone 		prompt 'Enter Telephone';
accept v_Fax 			prompt 'Enter Fax';
accept v_Email 			prompt 'Enter Email';

if ((select count(*) from Instructor) > 20) then 
insert into Instructor
values('&v_InstructorId','&v_DeptNo','&v_FirstName','&v_LastName',
        '&v_Telephone','&v_Fax','&v_Email');
end if;

accept x_value  number prompt 'Enter 1 to continue 0 to Stop';

begin
  if(&x_value = 0) then
  commit;
  DBMS_OUTPUT.PUT_LINE('Success');
  RAISE_APPLICATION_ERROR(-20000, 'Done'); 
  end if;								   
end;

/*
Assignement9: Write a PL/SQL block to display the count of employees whose gender is “Male”.
*/

set serveroutput on;
declare
var1 INTEGER;
Begin
select count(*) into var1 from Employee where Gender='Male';
DBMS_OUTPUT.PUT_LINE('Total number of Male employess: ' || var1); 
END;

/*
Assignement10: Write a PL/SQL block to display the class location details whose seating capacity is > 200.
*/

set serveroutput on;
declare
i INTEGER;
Begin
FOR i in (select ClassBuilding, ClassRoom from ClassLocation where SeatingCapacity > 200)
LOOP
DBMS_OUTPUT.PUT_LINE('Class Building:' || i.ClassBuilding ||'  Class Room:' || i.ClassRoom
|| 'Seating Capacity:' || i.SeatingCapacity);
END LOOP;
END;

/*
Assignement11: Write a PL/SQL block to insert only the odd numbers from 1 to 20 into Department table as Deptno and get the Department Name from the user.
*/

set serveroutput on;
declare
i number;
DeptName varchar(21);
DeptLocation varchar(13);
Begin
 FOR i in 1..20
 LOOP
  IF MOD(i,2)!=0 THEN
  DeptName:='&DeptName';
 DeptLocation:='&DeptLocation';
  insert into Department values (i, DeptName, DeptLocation);
  END IF;
 END LOOP;
END;

/*
Assignement12: Write a PL/SQL block to count the number of courses available in Course table.
*/

set serveroutput on;
declare
var1 number;
Begin
select count(distinct CourseId) into var1 from Course;
DBMS_OUTPUT.PUT_LINE('Total number of courses: ' || var1);
END;
