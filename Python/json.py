import json

# JSON to Dictionary
x = '{"name": "Peter", "age": 20}' # JSON bắt buộc dùng dấu "" cho key và value
y = json.loads(x)
print(y["name"])

# Dictionary to JSON
x = {
    "product": "Computer",
    "price": 100
}

y = json.dumps(x, indent=4) # indent = 4 format kết quả JSON
print(y)