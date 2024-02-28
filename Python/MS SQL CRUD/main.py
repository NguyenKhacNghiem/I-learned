import pyodbc

def add(cursor):
    sql = "insert into product (name, price) values (?, ?);"
    value = [
        ("Milk", 10),
        ("Candy", 20),
        ("Meat", 30),
        ("Water", 40),
        ("Egg", 50),
    ]

    cursor.executemany(sql, value)
    print("After adding:")

def update(cursor):
    sql = "update product set price = price + 5 where price < 30"
    cursor.execute(sql)
    
    print("Number of row updated:", cursor.rowcount)

def delete(cursor):
    sql = "delete from product where price < 30"
    cursor.execute(sql)
    
    print("Number of row deleted:", cursor.rowcount)

def show(cursor):
    sql = "select * from product"
    cursor.execute(sql)

    for row in cursor.fetchall():
        print(row)

def main():
    server = "nknghiem"
    database = "my_database"

    # Kết nối có username và password
    # username = ""
    # password = ""
    # connection = pyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER='+server+';DATABASE='+database+';UID='+username+';PWD='+ password)

    # Kết nối không cần username và password
    connection = pyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER='+server+';DATABASE='+database+';Trusted_Connection=yes;')

    cursor = connection.cursor()

    sql = """create table product (
                id int identity(1, 1) primary key, 
                name varchar(255), 
                price int
             )"""
    cursor.execute(sql)
    connection.commit()

    add(cursor)
    connection.commit()
    show(cursor)

    update(cursor)
    connection.commit()
    show(cursor)

    delete(cursor)
    connection.commit()
    show(cursor)

if __name__ == "__main__":
    main()