// GPath
println this.class.methods.name.grep(~/get.*/).sort()

// Spread operator
def getList() {
  return [1,2,3]
}
def sum(a,b,c) {
  return a + b + c
}
assert 6 == sum(*list)
def range = (1..3)
assert [0,1,2,3] == [0, *range]
def map = [a:1,b:2]
assert [a:1, b:2, c:3] == [c:3, *:map]

// categories with the 'use' keyword
class StringCalculationCategory {
  static def plus(String self, String operand) {
    try {
      return self.toInteger() + operand.toInteger()
    }
    catch (NumberFormatException fallback) {
      return (self << operand).toString()
    }
  }
}
use (StringCalculationCategory) {
  assert 1 == '1' + '0'
  assert 2 == '1' + '1'
  assert 'x1' == 'x' + '1'
}
