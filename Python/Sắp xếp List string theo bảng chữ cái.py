names = ["Peter", "David", "John", "Anna"]

sortByFirstCharacter = sorted(names)  # sap xep theo ky tu dau tien
print(sortByFirstCharacter)

sortByAnyCharacter = sorted(names, key=lambda element: element[1]) # sap xep theo ky tu thu 2
print(sortByAnyCharacter)

students = [{"name": "Peter", "age": 19}, {"name": "David", "age": 18}, {"name": "John", "age": 20}]
sortByName = sorted(students, key=lambda element: element["name"])
print(sortByName)