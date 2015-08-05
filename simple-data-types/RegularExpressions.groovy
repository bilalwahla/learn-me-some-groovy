// Regular expressions
twister = 'she sells sea shells at the sea shore of seychelles'

myregex = /t.e/
assert twister =~ myregex
twister.eachMatch(myregex) {
  match ->
  println match
}

regex = /\b(\w)\w*\1\b/
start = System.currentTimeMillis()
100000.times {
    twister =~ regex
}
first = System.currentTimeMillis() - start
start = System.currentTimeMillis()
pattern = ~regex // assigning ~String
100000.times{
    pattern.matcher(twister)
}
second = System.currentTimeMillis() - start
println second - first
