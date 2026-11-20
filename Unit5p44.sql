CREATE OR REPLACE PROCEDURE create_employee_table AS
BEGIN
    EXECUTE IMMEDIATE '
        CREATE TABLE employee (
            emp_id NUMBER PRIMARY KEY,
            emp_name VARCHAR2(50),
            emp_salary NUMBER,
            emp_dept VARCHAR2(30)
        )';
END;
/