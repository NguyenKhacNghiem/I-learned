
class Employee:

    def __init__(self, first, last):
        self.first = first
        self.last = last

    # Chuyển phương thức email() thành thuộc tính
    @property
    def email(self):
        return '{}.{}@email.com'.format(self.first, self.last)

    # Chuyển phương thức fullname() thành thuộc tính
    @property
    def fullname(self):
        return '{} {}'.format(self.first, self.last)
    
    # Cho phép thay đổi giá trị của thuộc tính có gắn @property
    @fullname.setter
    def fullname(self, name):
        first, last = name.split(' ')
        self.first = first
        self.last = last
    
    # Cho phép dùng câu lệnh del đối với thuộc tính có gắn @property
    @fullname.deleter
    def fullname(self):
        print('Delete Name!')
        self.first = None
        self.last = None


emp_1 = Employee('John', 'Smith')
emp_1.fullname = "Corey Schafer" # do có @fullname.setter nên có thể gọi để thay đổi giá trị bằng phép gán

print(emp_1.first)
print(emp_1.email)    # do có @property nên có thể gọi trực tiếp như thuộc tính mà ko cần dấu ()
print(emp_1.fullname) # do có @property nên có thể gọi trực tiếp như thuộc tính mà ko cần dấu ()

del emp_1.fullname # do có @fullname.deleter nên có thể dùng câu lệnh del
