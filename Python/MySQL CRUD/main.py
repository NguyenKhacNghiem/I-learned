import mysql.connector

def add(cursor):
    sql = "insert into product (name, price) values (%s, %s);"
    value = [
        ("Milk", 10),
        ("Candy", 20),
        ("Meat", 30),
        ("Water", 40),
        ("Egg", 50),
    ]

    cursor.executemany(sql, value)
    cursor.execute("commit;")

    print("After adding:")

def update(cursor):
    sql = "update product set price = price + 5 where price < 30"
    cursor.execute(sql)
    
    print("Number of row updated:", cursor.rowcount)
    cursor.execute("commit")

def delete(cursor):
    sql = "delete from product where price < 30"
    cursor.execute(sql)
    
    print("Number of row deleted:", cursor.rowcount)
    cursor.execute("commit")

def show(cursor):
    sql = "select * from product"
    cursor.execute(sql)

    for row in cursor.fetchall():
        print(row)

def main():
    mydb = mysql.connector.connect(
        host = "localhost",
        user = "root",
        password = ""
    )

    cursor = mydb.cursor()

    cursor.execute("create database my_database")
    cursor.execute("use my_database")

    sql = """create table product (
                id int auto_increment primary key, 
                name varchar(255), 
                price int
             )"""
    cursor.execute(sql)

    add(cursor)
    show(cursor)

    update(cursor)
    show(cursor)

    delete(cursor)
    show(cursor)

if __name__ == "__main__":
    main()