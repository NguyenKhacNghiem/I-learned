from Employee import Employee

class Developer(Employee):
    def __init__(self, name, address, base_salary, age, gender, exp_year, primary_language):
        super().__init__(name, address, base_salary, age, gender, exp_year)
        self.primary_language = primary_language
    
    def __str__(self):
        return f"""Developer[
            name: {self.name},
            address: {self.address},
            base_salary: {self.base_salary},
            age: {self.age},
            gender: {self.gender},
            exp_year: {self.exp_year},
            primary_language: {self.primary_language},
        ]"""

    def calculateSalary(self):
        return self.base_salary + 500000*self.exp_year