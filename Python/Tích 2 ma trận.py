def inputMatrix():
    a = []

    row   = int(input("Enter row: "))
    colum = int(input("Enter colum: "))

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

def getProductOfTwoMatrixes(a, b):  # nhan 2 ma tran
    if len(a[0]) != len(b):
        print("Matrix dimension error")
        return

    c = []

    for i in range(0, len(a)):
        for j in range(0, len(b[0])):
            c.append([])
            sum = 0

            for k in range(0, len(b)):
                sum += a[i][k]*b[k][j]
                
            c[i].append(sum)
    
    return c

def main():
    
    print("Enter matrix A: ")
    a = inputMatrix()
    print("Enter matrix B: ")
    b = inputMatrix()
    
    print("Matrix A: ")
    showMatrix(a)
    print("Matrix B: ")
    showMatrix(b)

    c = getProductOfTwoMatrixes(a, b)
    print("Matrix C = AxB: ")
    showMatrix(c)

if __name__ == "__main__":
    main()