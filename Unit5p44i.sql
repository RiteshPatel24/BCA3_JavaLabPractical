BEGIN
    INSERT INTO employee (emp_id, emp_name, emp_salary, emp_dept) 
    VALUES (101, 'John Smith', 55000, 'IT');
    
    INSERT INTO employee (emp_id, emp_name, emp_salary, emp_dept) 
    VALUES (102, 'Alice Brown', 62000, 'HR');
    
    INSERT INTO employee (emp_id, emp_name, emp_salary, emp_dept) 
    VALUES (103, 'Robert King', 48000, 'Sales');
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' records inserted successfully.');
END;
/