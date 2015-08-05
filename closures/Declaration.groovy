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
