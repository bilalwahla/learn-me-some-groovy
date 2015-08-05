// GString
println "Book $groovyBean.title"

// Language level support for regular expressions
assert '123456789' =~ /\d+/
assert 'nnn' == '123'.replaceAll(/\d/,'n')

// Numbers
def x = 1
def y = 2
assert x instanceof Integer
// So we can invoke methods on them
assert x.plus(y) == 3
// But we can also use operators with them
assert x + y == 3

// Lists
def roman = ['blank', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
roman[8] = 'VIII'
assert roman.size() == 9
println "List size is now $roman.size"

// Maps
def httpReturnCodes = [
  100 : 'CONTINUE',
  200 : 'OK',
  400 : 'BAD REQUEST'
]
assert httpReturnCodes[200] == 'OK'
httpReturnCodes[500] = 'INTERNAL SERVER ERROR'
println "Map size is now " + httpReturnCodes.size()

// Ranges
def range = 1..10
assert range.contains(5)
assert range.contains(15) == false
println "Range size: " + range.size() + ", from: $range.from and to: $range.to"
println "Reverse of the range is " + range.reverse()

// Closures
def totalClinks = 0
def partyPeople = 10
1.upto(partyPeople) {
  guestNumber ->
  clinksWithGuest = guestNumber-1
  totalClinks += clinksWithGuest
}
println "Number of clinks heard in a party of $partyPeople people: $totalClinks"
assert totalClinks == (partyPeople * (partyPeople-1)) / 2

String getTitleBackwards(book) {
  title = book.getTitle()
  return title.reverse()
}
