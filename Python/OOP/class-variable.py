class Employee:
    # Class variable
    company = 'ABC'

    # Constructor
    def __init__(self, firstname, lastname, age):
        self.first_name = firstname
        self.last_name = lastname
        self.age = age
        self.email = firstname.lower() + '_' + lastname.lower() + '@' + self.company.lower() + '.com'

    # Method
    def to_string(self):
        return self.__dict__ # Return all attributes of the object

# MAIN
# Create an object
e1 = Employee('Nguyen', 'Nghiem', 18)
e2 = Employee('Tran', 'Trinh', 19)

print(e1.to_string())
print(e2.to_string())
print(Employee.to_string(e1)) # This is the same as the above line

print(e1.company)       # ABC
print(e2.company)       # ABC
print(Employee.company) # ABC

e1.company = 'DEF'      # NOTE: company becomes an attribute of e1, not a class variable
print(e1.company)       # DEF
print(e2.company)       # ABC
print(Employee.company) # ABC

Employee.company = 'XYZ'
print(e1.company)       # DEF
print(e2.company)       # XYZ
print(Employee.company) # XYZ

print(e1.to_string())   # self.__dict__ add company attribute on line 29
print(e2.to_string())
print(Employee.to_string(e1))