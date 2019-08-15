/*
Assignment1: Write a PL/SQL block to display the total salary (ie., Salary + Comm) of each employee whose comm is not null.
*/

DECLARE 
   e_sal NUMBER(7,2);
   e_name VARCHAR2(30);
   CURSOR c_employee is 
      SELECT (Salary+Comm) as totalsalary, Ename FROM Employee where Comm is not null; 
BEGIN 
   OPEN c_employee; 
   LOOP 
   FETCH c_employee into e_sal, e_name; 
      EXIT WHEN c_employee%notfound; 
      DBMS_OUTPUT.PUT_LINE(e_sal || ' ' || e_name); 
   END LOOP; 
   CLOSE c_employee; 
END;

/*
Assignment2: Write a PL/SQL block to display the employee details, and the number of employees joined in each month.
*/

DECLARE 
   e_date varchar(20);
   e_count VARCHAR2(20);
   e_empno varchar(20);
   e_ename VARCHAR2(20);
   CURSOR c_employee is 
      select TO_CHAR(Hiredate, 'MONTH'),count(*) from Employee group by TO_CHAR(Hiredate, 'MONTH');
   CURSOR c_details is 
      select EmpNo, Ename from Employee ;  
BEGIN 
   OPEN c_details; 
   LOOP 
   FETCH c_details into e_empno, e_ename; 
      EXIT WHEN c_details%notfound; 
      DBMS_OUTPUT.PUT_LINE(e_empno || ' ' || e_ename); 
   END LOOP; 
   CLOSE c_details;
     DBMS_OUTPUT.PUT_LINE('-------------------');
   OPEN c_employee; 
   LOOP 
   FETCH c_employee into e_date, e_count; 
      EXIT WHEN c_employee%notfound; 
      DBMS_OUTPUT.PUT_LINE(e_date || ' ' || e_count); 
   END LOOP; 
   CLOSE c_employee; 
END;

/*
Assignment3: Write a PL/SQL block to increase the additional fees by 10% and if the additional fees exceeds 100 then decrease the additional fees by 20%.
*/

DECLARE 
   c_id VARCHAR2(5);
   c_addfees NUMBER(9,2);
   CURSOR c_course is 
      select CourseId, Additional_Fees from Course
      FOR update of Additional_Fees;
BEGIN 
   OPEN c_course; 
   LOOP 
   FETCH c_course into c_id, c_addfees; 
      EXIT WHEN c_course%notfound; 
      DBMS_OUTPUT.PUT_LINE(c_id || ' ' || c_addfees); 
      update course
              set Additional_Fees=case
                                      when Additional_Fees <100 then Additional_Fees*1.1
                                      when Additional_Fees >=100 then Additional_Fees*0.8
                                      else Additional_Fees
                                      end
                                      WHERE CURRENT OF c_course;
   END LOOP; 
   CLOSE c_course;
END;

/*
Assignment4: Write a PL/SQL block which displays the schedule type for a specified classroom entered by the user.
*/

DECLARE 
   c_room varchar(10);
   c_schdID VARCHAR2(30);
   c_schdes VARCHAR2(30);
   c_schday VARCHAR2(30);
   c_schstart VARCHAR2(30);
   c_schddura VARCHAR2(30);
   CURSOR c_class is 
      select c.classroom, s.* 
	  from Class c join Schedule_Type s 
	  on c.ScheduleId=s.ScheduleId 
	  where c.DeptNo = &DeptNo; 
BEGIN 
   OPEN c_class; 
   LOOP 
   FETCH c_class into c_room, c_schdID, c_schdes, c_schday, c_schstart, c_schddura; 
      EXIT WHEN c_class%notfound; 
      DBMS_OUTPUT.PUT_LINE(c_room || ' ' || c_schdID || ' ' || c_schdes 
	  || ' ' || c_schday || ' ' || c_schstart || ' ' || c_schddura); 
   END LOOP; 
   CLOSE c_class; 
END; 

/*
Assignment5: Write a PL/SQL block to display the employee details whose gender is Male.
*/

DECLARE 
   e_empno NUMBER(38,0);
   e_ename VARCHAR2(30);
   e_Job VARCHAR2(12);
   e_mgr NUMBER(38,0);
   e_hiredate DATE;
   e_salary NUMBER(7,2);
   e_comm NUMBER(7,2);
   e_deptno NUMBER(38,0);
   e_gender VARCHAR2(12);
   CURSOR e_emp is 
      select * from Employee where Gender = 'Male';
BEGIN 
   OPEN e_emp; 
   LOOP 
   FETCH e_emp into e_empno, e_ename, e_job, e_mgr, e_hiredate, 
		 e_salary, e_comm, e_deptno, e_gender; 
      EXIT WHEN e_emp%notfound; 
      DBMS_OUTPUT.PUT_LINE(e_empno || ' ' || e_ename || ' ' || e_job 
	  || ' ' || e_mgr || ' '|| e_hiredate || ' ' || e_salary || ' ' 
	  || e_comm || ' ' || e_deptno || ' ' || e_gender); 
   END LOOP; 
   CLOSE e_emp; 
END; 

/*
Assignment6: Write a PL/SQL block to count the number of students available in each city.
*/

DECLARE 
   s_stud varchar2(20);
   s_count VARCHAR2(12);
   CURSOR s_stud is 
      select City, count(*) from Student group by City;
BEGIN 
   OPEN s_stud; 
   LOOP 
   FETCH s_stud into s_stud, s_count; 
      EXIT WHEN s_stud%notfound; 
      DBMS_OUTPUT.PUT_LINE(s_stud || ' ' || s_count); 
   END LOOP; 
   CLOSE s_stud; 
END;

/*
Assignment7: Write a PL/SQL block to display the class location details whose seating capacity is >= 200.
*/

DECLARE 
   s_classbuild varchar2(20);
   s_classroom VARCHAR2(12);
   CURSOR s_stud is 
      select ClassBuilding, ClassRoom from ClassLocation where SeatingCapacity >= 200;
BEGIN 
   OPEN s_stud; 
   LOOP 
   FETCH s_stud into s_classbuild, s_classroom; 
      EXIT WHEN s_stud%notfound; 
      DBMS_OUTPUT.PUT_LINE(s_classbuild || ' ' || s_classroom); 
   END LOOP; 
   CLOSE s_stud; 
END;

/*
Assignment8: Write a PL/SQL block to display all the students whose grade = ‘A’.
*/

DECLARE 
   s_studID varchar2(20);
   CURSOR s_stud is 
      select StudentID from StudentSchedule where Grade = 'A';
BEGIN 
   OPEN s_stud; 
   LOOP 
   FETCH s_stud into s_studID; 
      EXIT WHEN s_stud%notfound; 
      DBMS_OUTPUT.PUT_LINE(s_studID); 
   END LOOP; 
   CLOSE s_stud; 
END;

/*
Assignment9: Write a PL/SQL block to display the details of the instructor who are handling for 1st semester.
*/

DECLARE 
   s_instID varchar2(20);
   s_instname varchar2(20);
   CURSOR s_stud is 
      select i.InstructorID, i.FirstName 
	  from Instructor i join Class c 
	  on i.InstructorID = c.InstructorID;
BEGIN 
   OPEN s_stud; 
   LOOP 
   FETCH s_stud into s_instID, s_instname; 
      EXIT WHEN s_stud%notfound; 
      DBMS_OUTPUT.PUT_LINE(s_instID || ' ' || s_instname); 
   END LOOP; 
   CLOSE s_stud; 
END;

/*
Assignment10: Write a PL/SQL block to display all the records available from the table named StudentSchedule.
*/
DECLARE 
   s_studID varchar2(20);
   s_classID varchar2(20);
   s_grade varchar2(20);
   s_gradeassigned varchar2(20);
   CURSOR s_stud is 
      select * from StudentSchedule ;
BEGIN 
   OPEN s_stud; 
   LOOP 
   FETCH s_stud into s_studID, s_classID, s_grade, s_gradeassigned; 
      EXIT WHEN s_stud%notfound; 
      DBMS_OUTPUT.PUT_LINE(s_studID || ' ' || s_classID || ' ' || s_grade || ' ' || s_gradeassigned); 
   END LOOP; 
   CLOSE s_stud; 
END;
