// Currying
def adder = {x, y -> return x+y}
// Fixing value of the first parameter
def addOne = adder.curry(1)
assert addOne(5) == 6
// Fixing values of both parameters
def addOneAndTwo = adder.curry(1,2)
assert addOneAndTwo() == 3
