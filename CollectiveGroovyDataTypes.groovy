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

// Lists
longList = (0..1000).toList()
// Subscript operator
println longList[555]
myList = ['a','b','c','d','e','f']
myList[1..1] = ['y','1','2']
assert myList == ['a','y','1','2','c','d','e','f']
println myList
// Negative indexing
assert myList[-8] == 'a'
println 'Get at negative index -8: ' + myList[-8]
// Adding and removing items: plus, leftShift/append, minus and multiply
myList += '1'
myList << 'x'
println myList - ['f']
assert myList * 2 == ['a','y','1','2','c','d','e','f','1','x','a','y','1','2','c','d','e','f','1','x']
println myList * 2
// Intersection filter
def filter = ['y','1','2',1,111,222,333]
println filter.grep(myList)
// More methods
println 'The list: ' + myList
println 'The sorted List: ' + myList.sort()
println 'The unique list: ' + myList.unique()
println 'List for the set for the list: ' + new HashSet(myList).toList()
def doubled = [1,2,3].collect {
  item ->
  item*2
}
println doubled
def odd = [1,2,3,4,5].findAll {
  item ->
  item % 2 == 1
}
println odd
def list = [1,2,3]
result = list.inject(0) {
  clinks, guests ->
  clinks += guests
}
println result
// Tony Hoare’s Quicksort1 algorithm. Uses recursion
def quickSort(list) {
  if(list.size() < 2) return list
  def pivot = list[list.size().intdiv(2)]
  def left = list.findAll {item -> item <  pivot}
  def middle = list.findAll {item -> item == pivot}
  def right = list.findAll {item -> item > pivot}
  return (quickSort(left) + middle + quickSort(right))
}
println quickSort([1,3,5,4,2,7])
println 'Quick-sorted duck typed items: ' + quickSort([1.0f,'a',10,null])

// Maps
def myMap = [a:1,b:2,c:3]
def otherMap = [d:4,e:5,f:6]
println myMap['a']
def emptyMap = [:]
// Just like explicit lists you can define explicit maps too.
def explicitMap = new TreeMap()
explicitMap.putAll(myMap)
println explicitMap.b
println myMap.any{
  entry -> entry.value > 2
}
assert myMap.every {entry -> entry.key > 'f'} == false
def store = ''
myMap.each {key, value ->
  store += key
  store += ':' + value
}
println store
myMap.remove('a')
println myMap
println myMap.findAll {
  entry ->
  entry.value == 1
}
// Collect a list of doubled values from the map and add to an existing list
def existingList = [8,10]
def doubledMapList = myMap.collect(existingList) { entry -> entry.value *= 2}
println doubledMapList.sort()
// Baloo the bear's anthem
def textCorpus =
"""
Look for the bare necessities
The simple bare necessities
Forget about your worries and your strife
I mean the bare necessities
Old Mother Nature's recipes
That bring the bare necessities of life
"""
// Create the list of words
def words = textCorpus.tokenize()
def wordFrequency = [:]
words.each {
  word ->
  // Add (with default value of 0)/Update to the map with an increment
  wordFrequency[word] = wordFrequency.get(word,0) + 1
}
def wordList = wordFrequency.keySet().toList()
wordList.sort {
  /*
  Implementing comparing logic of 'wordList' on the 'wordFrequency' map i.e. on
  an object totally different from the 'wordList' itself.
  */
  wordFrequency[it]
}
def statistic = "\n"
wordList.each {
  word ->
  statistic += word.padLeft(12)    + ': '
  statistic += wordFrequency[word] + "\n"
}
println statistic
