try:
  print(x) # x not defined will throw exception NameError
  # raise Exception("My Exception") # raise an exception
except NameError: # When occur NameError exception
  print("Variable x is not defined")
except: # When occur orther exceptions
  print("Something else went wrong")
else: # When occur no exceptions
  print("Nothing went wrong")
finally: # when occur any exception or not
  print("Finished try-except")