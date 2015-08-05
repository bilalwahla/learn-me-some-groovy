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
