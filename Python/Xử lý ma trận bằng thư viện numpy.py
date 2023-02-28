import numpy 

# Create 2 matrixs 
x = numpy.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
y = numpy.array([[2, 3, 4], [3, 1, 5], [1, 2, 3]])

# x + y
print(numpy.add(x, y)) 

# x - y
print(numpy.subtract(x, y)) 

# 2 * x
print(2*x)

# x * y
print(numpy.dot(x, y))

# power of matrix
print(numpy.linalg.matrix_power(x, 3))

# inverse of matrix -> Tim ma tran nghich dao. Neu khong tim duoc thi bao loi
print(numpy.linalg.inv(y))

A = numpy.array([[4,5],[3,4]]) 
B = numpy.array([[1,3],[1,2]]) 
# AX = B <-> X = A^-1 * B
X = numpy.dot(numpy.linalg.inv(A), B)
print(X)

# XA = B <-> X = B * A^-1
X = numpy.dot(B, numpy.linalg.inv(A))
print(X)


