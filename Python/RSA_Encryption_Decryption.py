import math
import random

def isPrimeNumber(n):
    if n<2:
        return False
    
    i = 2
    while i <= math.sqrt(n):
        if n % i == 0:
            return False
        i += 1
    
    return True

def getPAndQ():
    while True:
        n = random.randint(2, 50)

        if isPrimeNumber(n):
            return n

def calculateE(p, q, fn):
    e = 2
    factors = [] # chua cac uoc so cua fn 

    i = 2
    while i < fn:
        if fn % i == 0:
            factors.append(i)
        i += 1

    while e < fn:
        isBoiSo = False
        
        for j in range(len(factors)):
            if e % factors[j] == 0:
                isBoiSo = True
        
        if isBoiSo == False and e != p and e != q:
            return e
        
        e += 1
   
def encryption(plaintext, e, n):
    ciphertext = ''

    for i in plaintext:
        c = pow(ord(i), e, n)
        ciphertext += chr(c)

    return ciphertext

def decryption(ciphertext, d, n):
    plaintext = ''

    for i in ciphertext:
        c = pow(ord(i), d, n)
        plaintext += chr(c)
    
    return plaintext

######### Main #########    
p = 0
q = 0

# Choose random p and q
while p == q:
    p = getPAndQ()
    q = getPAndQ() 

print('Chon random so nguyen to p =', p)
print('Chon random so nguyen to q =', q)

# Calculate n
n = p * q
print('Tinh n = p * q =', p, '*', q, '=', n)

# Calculate fn
fn = (p-1)*(q-1)
print('Tinh fn = (p-1)*(q-1) =', p-1, '*', q-1, '=', fn)

# Calculate e
e = calculateE(p, q, fn)
print('-> e =', e)

# Calculate d
d = 1
while True:
    if ((d * e) % fn) == 1:
        break
    d += 1 

print('-> d =', d)

# Calculate PU and PR
print('-> PU = {', e, ',', n, '}')
print('-> PR = {', d, ',', n, '}')

plaintext = 'hello'

# Encryption
ciphertext = encryption(plaintext, e, n)
print('Cipher text:', ciphertext)

# Decryption
print('Plain text:', decryption(ciphertext, d, n))
