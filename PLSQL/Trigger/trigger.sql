SET SERVEROUTPUT ON;

CREATE TABLE employee
(
    id NUMBER(3) GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    age NUMBER(3)
);

/* TABLE AUDITING USING TRIGGERS */
CREATE TABLE employee_audit
(
    new_name VARCHAR2(30),
    old_name VARCHAR2(30),
    user_name VARCHAR2(30),
    entry_date VARCHAR2(30),
    action VARCHAR2(30)
);

CREATE OR REPLACE TRIGGER audit_trigger
BEFORE INSERT OR UPDATE OR DELETE ON employee
FOR EACH ROW
ENABLE
DECLARE
    v_user VARCHAR2(30);
    v_date VARCHAR2(30);
BEGIN
    SELECT user, TO_CHAR(SYSDATE, 'DD/MM/YYYY HH:MM:SS') INTO v_user, v_date FROM dual;
    
    IF INSERTING THEN
        INSERT INTO employee_audit VALUES(:NEW.name, NULL, v_user, v_date, 'INSERTING');
    ELSIF DELETING THEN
        INSERT INTO employee_audit VALUES(NULL, :OLD.name, v_user, v_date, 'DELETING');
    ELSIF UPDATING THEN
        INSERT INTO employee_audit VALUES(:NEW.name, :OLD.name, v_user, v_date, 'UPDATING');
    END IF;
END;
/

/* MAKE SYNCHRONIZED BACKUP OF A TABLE USING TRIGGER */
CREATE TABLE employee_backup AS SELECT * FROM employee;
DESC employee_backup;

CREATE OR REPLACE TRIGGER backup_trigger
BEFORE INSERT OR UPDATE OR DELETE ON employee
FOR EACH ROW
ENABLE
BEGIN
    IF INSERTING THEN
        INSERT INTO employee_backup VALUES(:NEW.id, :NEW.name, :NEW.age);
    ELSIF UPDATING THEN
        UPDATE employee_backup SET name = :NEW.name, age = :NEW.age WHERE id = :OLD.id;
    ELSIF DELETING THEN
        DELETE FROM employee_backup WHERE id = :OLD.id;
    END IF;
END;
/

INSERT INTO employee (name, age) VALUES('Helen', 22);
INSERT INTO employee (name, age) VALUES('Alice', 23);
UPDATE employee SET name = 'Cici' WHERE id = 2;
DELETE FROM employee WHERE id = 3;

SELECT * FROM employee_audit;
SELECT * FROM employee;
SELECT * FROM employee_backup;

/* DDL TRIGGER */
CREATE TABLE schema_audit
(
    ddl_date Date,
    ddl_user VARCHAR2(30),
    object_created VARCHAR2(30),
    object_name VARCHAR2(30),
    ddl_desc VARCHAR2(30)
);

CREATE OR REPLACE TRIGGER ddl_trigger
AFTER DDL ON SCHEMA -- gọi trigger sau mỗi sự kiện DDL trên bất kỳ đối tượng nào thuộc về Schema hiện tại 
BEGIN
    INSERT INTO schema_audit VALUES (
        SYSDATE, -- lấy ngày hiện tại
        SYS_CONTEXT('USERENV', 'CURRENT_USER'), -- người dùng hiện tại thực hiện thao tác DDL
        ORA_DICT_OBJ_TYPE, -- đối tượng đang được thực hiện DDL (table, view, procedure, ...)
        ORA_DICT_OBJ_NAME, -- tên đối tượng đang được thực hiện DDL
        ORA_SYSEVENT -- loại sự kiện (CREATE, INSERT, UPDATE, ...)
    );
END;
/

SELECT * FROM schema_audit;






