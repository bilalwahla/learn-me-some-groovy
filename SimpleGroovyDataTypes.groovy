// Autoboxing
println 'ABCDEF'.indexOf(67)

def x = 1
def y = 2
assert x instanceof Integer
// So we can invoke methods on them
assert x.plus(y) == 3
// But we can also use operators with them
assert x + y == 3

// Overriding operators
class Money {
  private int amount
  private String currency

  Money(amountValue, currencyValue) {
    amount = amountValue
    currency = currencyValue
  }

  boolean equals(Object other) {
    if (null == other)
    if (!(other instanceof Money))
      return false
    if (currency != other.currency)
      return false
    if (amount != other.amount)
      return false
    return true
  }

  // This is required by Java’s contract for java.lang.Object
  /*int hashCode() {
    amount.hashCode() + currency.hashCode()
  }*/

  // Operator implementing
  Money plus(Money other) {
    if (null == other) return null
    if (other.currency != currency) {
      throw new IllegalArgumentException("cannot add $other.currency to $currency")
    }
    return new Money(amount + other.amount, currency)
  }

  // Overloaded + though closed in its type i.e. return type
  Money plus(Integer more) {
    return new Money(amount + more, currency)
  }
}

def quid = new Money(1, 'GBP')
def doubleQuid = quid + quid
println "$doubleQuid.amount quid"
// This uses the overloaded +
def tenGrand = doubleQuid + 10000
println tenGrand.amount

// Coercion
/* Integer plus BigDecimal should return a BigDecimal that accommodates both
types. This is known as double dispatch
*/
println 20 + 20.222

// Working with the humble strings
greeting = 'Hello Groovy!'
println 'Hi' + greeting - 'Hello'
println greeting.center(81, '-')
println greeting[6..11]

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

// Numbers and their methods
def store = ''
1000.step(50000, 9000 ){ number ->
    store += number + ' '
}
println store
