/**
 * @author bilalwahla
 *
 * Go through the given number dividing it in accordance with the values we have
 * against the available Roman numerals, building a string starting with the largest
 * numeral. Code attempts to apply additive notation until four characters are being
 * repeated in succession in which case it attempts to apply subtractive notation.
 *
 * Assumptions for subtractive notation:
 * * the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX)
 * * X can be placed before L and C to make 40 (XL) and 90 (XC)
 * * C can be placed before D and M to make 400 (CD) and 900 (CM)
 *
 */
numberToTransform = 801
symbols = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
values = [1000, 500, 100, 50, 10, 5, 1]
StringBuilder romanNumeral = new StringBuilder()
leftover = numberToTransform
(0 ..< values.size()).each {
  index ->
  count = leftover.intdiv(values[index])
  remainder = leftover%values[index]
  if(index == 0 || count != 4) {
    (0 ..< count).each {
        romanNumeral.append(symbols[index])
    }
    leftover -= count*values[index]
  } else {
    romanNumeral.append(symbols[index])
    romanNumeral.append(symbols[index-1])
    leftover -= count*values[index]
  }

  if (index < values.size()-2 && remainder.intdiv(values[index+2]) == 9 && index%2 == 0) {
    romanNumeral.append(symbols[index+2])
    romanNumeral.append(symbols[index])
    leftover -= 9*values[index+2]
  }
}
// For number 801
assert romanNumeral.toString() == 'DCCCI'
println romanNumeral
