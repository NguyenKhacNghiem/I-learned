s = input("Enter s: ")

# loai bo cac khoang trang thua
items = s.lower().split(" ") 
s = ""
for i in items:
    if len(i) > 0:
        s += i + " "

# in hoa chu cai dau tien cua moi tu va tao khoang trang giua moi tu
items = s.split(" ") 
s = ""
for i in items:
    s += i.capitalize() + " "

s = s.rstrip(" ")  # loai bo cac khoang trang o cuoi chuoi bi du
print(s)


