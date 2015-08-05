// Numbers and their methods
def x = 1
def y = 2
assert x instanceof Integer
// So we can invoke methods on them
assert x.plus(y) == 3
// But we can also use operators with them
assert x + y == 3

def store = ''
1000.step(50000, 9000 ){ number ->
    store += number + ' '
}
println store
