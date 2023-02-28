# libraries
import string

# global variables
asciiList = string.printable
plain_text = 'I am a student. I am attending in Bachelor of IT'

# functions
def encryption_decryption_reverse(text):
    result = ''

    i = len(text) - 1

    while i >= 0:
        result += text[i]
        i -= 1

    return result

def encryption_decryption_bit(text, key, mode):
    result = ''
    i = 0

    while i < len(text):
        j = 0

        while j < len(asciiList):
            if asciiList[j] == text[i]:
                break
            j += 1

        if mode == 'encrypt':
            result += asciiList[j+key]
        elif mode == 'decrypt':
            result += asciiList[j-key]
        else:
            return 'Error mode !!!' # do nothing

        i += 1
    
    return result

# Reverse Encryption
encrypt = encryption_decryption_reverse(plain_text)
print('The cipher text is: ', encrypt)

# Reverse Decryption
decrypt = encryption_decryption_reverse(encrypt)
print('The plain text is', decrypt)

# Bit Encryption (Caesar Cipher)
encrypt = encryption_decryption_bit(plain_text, 5, 'encrypt')
print('The cipher text is: ', encrypt)

# Bit Decryption (Caesar Cipher)
decrypt = encryption_decryption_bit(encrypt, 5, 'decrypt')
print('The plain text is: ', decrypt)

