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
