// Play Book
Book b = new Book('Groovy in Action')
assert b.getTitle() == 'Groovy in Action'
println getTitleBackwards(b)

// Play BookGroovyBean
BookGroovyBean groovyBean = new BookGroovyBean()
groovyBean.title = 'Groovy Bean in Action'
println(groovyBean.title)

// GString
println "Book $groovyBean.title"

String getTitleBackwards(book) {
  title = book.getTitle()
  return title.reverse()
}
