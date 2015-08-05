//Ranges
// Inclusive
assert (0..10).contains(10)
assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false
// Half-exclusive
assert (0..<10).contains(9)
assert (0..<10).contains(10) == false
// Explicit construction
a = new IntRange(0,10)
assert a.contains(5)
// Date ranges
def today = new Date()
def yesterday = today-1
assert (yesterday..today).size() == 2
// String ranges
def rangeOfStrings = 'a'..'d'
def strings = ''
assert rangeOfStrings.contains('b')
for(string in rangeOfStrings) {
  // next and previous methods on String make them usable for ranges
  strings += string.next()
}
println strings
// for-in-range loop
def log = ''
for(element in 5..9) {
  log += element
}
println log
// Walk through the range using each with closure
log = ''
(1..<5).each {
  element ->
  log += element
}
assert log == '1234'
println log
// Ranges as switch cases
age = 36
switch(age) {
  case 16..20 : insuranceRate = 0.05 ; break
  case 21..50 : insuranceRate = 0.06 ; break
  case 51..65 : insuranceRate = 0.07 ; break
  default: throw new IllegalArgumentException()
}
println "Insurance rate: $insuranceRate"
