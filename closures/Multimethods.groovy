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
