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
