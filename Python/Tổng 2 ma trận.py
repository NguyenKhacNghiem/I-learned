def inputMatrix(row, colum):
    a = []

    for i in range(0, row):
        a.append([])
        for j in range(0, colum):
            x = int(input("[%d][%d]: " % (i+1, j+1)))
            a[i].append(x)
    
    return a

def showMatrix(a):
    for i in range(0, len(a)):
        for j in range(0, len(a[0])):
            print(a[i][j], end=' ')
        print() # \n

def getSumOfTwoMatrixes(a, b):  # tong 2 ma tran
    c = []

    for i in range(0, len(a)):
        c.append([])
        for j in range(0, len(a[0])):
            c[i].append(a[i][j] + b[i][j])
    
    return c

def main():
    row   = int(input("Enter row: "))
    colum = int(input("Enter colum: "))

    print("Enter matrix A: ")
    a = inputMatrix(row, colum)
    print("Enter matrix B: ")
    b = inputMatrix(row, colum)
    
    print("Matrix A: ")
    showMatrix(a)
    print("Matrix B: ")
    showMatrix(b)

    c = getSumOfTwoMatrixes(a, b)
    print("Matrix C = A+B: ")
    showMatrix(c)

if __name__ == "__main__":
    main()