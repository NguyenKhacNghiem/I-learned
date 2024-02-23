SET SERVEROUTPUT ON;

/* CREATE TABLE AND INSERT DATA */
CREATE TABLE employee
(
    id NUMBER(3) GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    age NUMBER(3)
);

INSERT INTO employee(name, age) VALUES ('David', 18);
INSERT INTO employee(name, age) VALUES ('John', 19);
INSERT INTO employee(name, age) VALUES ('Peter', 20);
SELECT * FROM employee;

/*
    Variable gồm 2 loại:
    + User variable
    + Bind variable (hay host variable): là những biến được tạo ra trong SQL*Plus
    (không cần viết trong PL/SQL Block) và được tham chiếu trong PL/SQL.
*/

/* DECLARE USER VARIABLE */
DECLARE
    v_string VARCHAR2(15);
BEGIN
    v_string := 'Hello World';
    DBMS_OUTPUT.PUT_LINE(v_string);
END;
/

/* DECLARE AND ASSIGN BIND VARIABLE */ 
-- Cách 1:
VARIABLE v_bind VARCHAR2(15);
EXEC :v_bind := 'Hello World!';
PRINT :v_bind;
-- Cách 2:
VARIABLE v_bind VARCHAR2(15);
BEGIN
    :v_bind := 'Hello World!';
    DBMS_OUTPUT.PUT_LINE(:v_bind);
END;
/

/* SELECT INTO */
DECLARE
    v_name VARCHAR(100);
    v_age NUMBER(3);
BEGIN
    SELECT name, age INTO v_name, v_age from employee where id = 2;
    DBMS_OUTPUT.PUT_LINE(v_name || ': ' || v_age);
END;
/

/* ANCHORED DATATYPE */
DECLARE
    v_name employee.name%TYPE;
    v_age employee.age%TYPE;
BEGIN
    SELECT name, age INTO v_name, v_age from employee where id = 2;
    DBMS_OUTPUT.PUT_LINE(v_name || ': ' || v_age);
END;
/

/* CONDITION STATEMENT */
DECLARE
    v_number2 NUMBER := &input;
BEGIN
    IF MOD(v_number2, 2) = 0 THEN
        DBMS_OUTPUT.PUT_LINE(v_number2 || ' is even');
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_number2 || ' is odd');
    END IF;
END;
/

/* LOOP */
DECLARE
    v_count NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(10 || 'x' || v_count || '=' || 10*v_count);
        v_count := v_count + 1;
        
--        IF v_count = 11 THEN
--            EXIT;
--        END IF;

        EXIT WHEN v_count = 11;
        
    END LOOP;
END;
/

--/* TRIGGER */
CREATE OR REPLACE TRIGGER bi_employee
BEFORE INSERT ON employee
FOR EACH ROW
ENABLE
DECLARE
    v_user VARCHAR(10);
BEGIN
    SELECT user INTO v_user FROM DUAL;
    DBMS_OUTPUT.PUT_LINE('Current user: ' || v_user);
END;
/ 

CREATE OR REPLACE TRIGGER bi2_employee
BEFORE INSERT ON employee
FOR EACH ROW FOLLOWS bi_employee
ENABLE
DECLARE
    v_user VARCHAR(10);
BEGIN
    SELECT user INTO v_user FROM DUAL;
    DBMS_OUTPUT.PUT_LINE('Current user 2: ' || v_user);
END;
/

INSERT INTO employee(name, age) VALUES ('Cici', 24);

CREATE OR REPLACE TRIGGER check_action
BEFORE INSERT OR UPDATE OR DELETE ON employee
FOR EACH ROW
ENABLE    
BEGIN
    IF INSERTING THEN DBMS_OUTPUT.PUT_LINE('ACTION: INSERTING');
    ELSIF UPDATING THEN DBMS_OUTPUT.PUT_LINE('ACTION: UPDATING');
    ELSE DBMS_OUTPUT.PUT_LINE('ACTION: DELETING');
    END IF;
END;
/

INSERT INTO employee(name, age) VALUES ('Cici', 24);
UPDATE employee SET name = 'Cici2' where age = 24;
DELETE FROM employee WHERE name = 'Cici2';

SELECT * FROM employee