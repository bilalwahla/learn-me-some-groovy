// Closures
// Method closure assignment
class MethodClosureSample {
  private int limit
  MethodClosureSample (int limit) {
    this.limit = limit
  }
  boolean validate (String value) {
    return value.length() <= limit
  }
}
MethodClosureSample mcs = new MethodClosureSample(3)
println mcs.validate('four') // Prints false
MethodClosureSample mcs2 = new MethodClosureSample(6)
Closure c = mcs2.&validate
// Now use this closure
def words = ['long string', 'medium', 'short', 'bit']
assert 'medium' == words.find(c)
// Or do it directly
assert 'bit' == words.find(mcs.&validate)
// Method closures are limited to instance methods
// multimethods aka runtime overload resolution
class MultiMethodSample {
  int mysteryMethod (String value) {
    return value.length()
  }
  int mysteryMethod (List list) {
    return list.size()
    }
  int mysteryMethod (int x, int y) {
    return x+y
  }
}
MultiMethodSample instance = new MultiMethodSample()
Closure multi = instance.&mysteryMethod // Only one closure is created
println multi('abcd ef')
// Currying
def adder = {x, y -> return x+y}
// Fixing value of the first parameter
def addOne = adder.curry(1)
assert addOne(5) == 6
// Fixing values of both parameters
def addOneAndTwo = adder.curry(1,2)
assert addOneAndTwo() == 3
