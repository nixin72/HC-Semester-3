/*
PART A
*/
/*1*/
select name from genre; 

/*2*/
select genreId from genre where name='Latin';

/*3*/
select firstname, lastname from employee where reportsto IS NULL;

/*
PART B
*/

/*1*/
UPDATE employee 
  SET FirstName = 'Stephen'
  WHERE EmployeeId = 5;
  COMMIT;
  
  SELECT * FROM Employee WHERE FirstName = 'Stephen';
  
/*2*/
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, 
            BirthDate, HireDate, 
            Address, City, State, Country, PostalCode, 
            Phone, Fax, Email) 
                      
            VALUES (9, 'Philip', 'Dumaresq', 'Big Kahuna', 
            TO_DATE('1998-08-04','yyyy-mm-dd'), TO_DATE('2002-8-14','yyyy-mm-dd'), 
            '36 Rue St-Malo', 'Aylmer', 'QC', 'Canada', 'J9J 0W2', 
            '(613) 447-4889', null, '1523066@cegep-heritage.qc.ca'
                      
            );
            
/*3*/
DELETE FROM employee WHERE employeeid=7;
  
  
/*
PART C
*/
  
  