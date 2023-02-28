def removeDuplicated(a):        
    b = []

    for i in a:
        if i not in b:
            b.append(i)
    
    print(b)

def main():
    a = [1, 2, 3, 4, 2, 3, 5]

    removeDuplicated(a)

if __name__ == "__main__":
    main()