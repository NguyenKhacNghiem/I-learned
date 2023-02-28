def encrypt_decrypt_shift_bit_multi_keys(text, keys, n, mode):
    result = ""
    count = 0

    # traverse text
    for i in range(len(text)):
        char = text[i]
        index = count % n

        if(str(char) != " "):
            if(mode == "encrypt"):
                # Encrypt uppercase characters
                if(char.isupper()):
                    result += chr((ord(char) + keys[index]-65) % 26 + 65)
                # Encrypt lowercase characters
                else:
                    result += chr((ord(char) + keys[index]-97) % 26 + 97)

            elif(mode == "decrypt"):
                # Decrypt uppercase characters
                if(char.isupper()):
                    result += chr((ord(char) - keys[index]-65) % 26 + 65)
                # Decrypt lowercase characters
                else:
                    result += chr((ord(char) - keys[index]-97) % 26 + 97)

            else:
                return "Invalid mode !!"
        else:
            result += char
        
        count += 1

    return result

# check the above function
text = "AAAAA BB CC DDD"
keys = [4, 5, 2, 7, 8, 3, 1]
n = len(keys)

print("Text: " + text)
print("Shift: " + str(keys))

cipher = encrypt_decrypt_shift_bit_multi_keys(text, keys, n, "encrypt")
print("Cipher: " + cipher)

plainText = encrypt_decrypt_shift_bit_multi_keys(cipher, keys, n, "decrypt")
print("After decrypting, we have a plainText: " + plainText)
